const socket = new SockJS('http://localhost/websocket');
const stompClient = Stomp.over(socket);
new Vue({
    el: "#app",
    data() {
        return {
            localUser: {},          // 本用户
            histories: [],           //历史记录
            selectedHistory: null,  //选择的历史记录,就是histories的下标
            messages: [],
            inputText: '',

            //弹窗
            modalVisible: false,
            historyInput: '',

            //打字
            textToType: "",
            typedText: "",
            index: 0,

            //websocket
            stompClient: stompClient,
            receivedMessages: {},

            //删除历史记录的小弹窗
            showConfirm: false,
            confirmIndex: -1,

            //删除全部历史记录的小弹窗
            showDeleteAllHistories : false,

            //编辑历史名字
            showEditHistoryName: false,
            editedHistoryName: '',
        };
    },
    async mounted() {
        //连接websocket
        this.connect();
        await this.getUser();
        await this.getAllHistory();
    },
    methods: {
        //选择历史记录，选择了应该更新聊天信息
        async selectHistory(index) {
            this.showConfirm = false;
            let _this = this;
            this.selectedHistory = index;
            //根据历史记录的id获取聊天记录
            await axios.get('/record/' + _this.histories[index].historyId)
                .then(response => {
                    console.log(response.data.data);
                    _this.messages = _this.processChatRecords(response.data.data);
                })
                .catch(error => {
                    console.error(error);
                });
        },
        async getUser() {
            let _this = this;
            //发送ajax请求
            await axios.get('/user/getUser')
                .then(response => {
                    // 请求成功时处理 response.data
                    // console.log(response.data.data);
                    _this.localUser = response.data.data;
                })
                .catch(error => {
                    console.error(error);
                });
        },
        async getAllHistory() {
            let _this = this;
            //根据id查询历史记录 避坑，字符串拼接用""比较好，不要用''
            await axios.get("/history/" + _this.localUser.userId)
                .then(response => {
                    // 请求成功时处理 response.data
                    console.log(response.data.data);
                    _this.histories = response.data.data;
                })
                .catch(error => {
                    console.error(error);
                });
        },

        scrollToBottom() {
            this.$refs.messageContainer.scrollTop = this.$refs.messageContainer.scrollHeight;
        },
        //把后端的数据转化为前端messages的数据格式
        processChatRecords(chatRecords) {
            const messages = [];
            /*把后端的数据转化为前端messages的数据格式
            ChatRecord = [{
                recordId=1,
                historyId=1,
                content='你好',
                AiResponse = {
                    aiResponseId=1,
                    recordId=1,
                    content='您好，请问有什么需要帮助的吗'
               } ...]
             }
             */
            chatRecords.forEach((record) => {
                // 用户消息
                messages.push({
                    text: record.content,
                    isMine: true
                });
                // AI回应
                messages.push({
                    text: record.aiResponse.content,
                    isMine: false
                });
            });

            return messages;
        },
        showAddHistoryModal() {
            this.modalVisible = true;
            this.startTextToType("您输入的prompt将作为Ai的系统默认角色,请务必好好填写,不然会影响对话体验！输入为空则进入系统默认");
        },
        async submitData() {
            let history = {
                aiPrompt: null,
                historyId: null,
                historyName: '测试',
                userAiPrompt: this.historyInput,
                userId: this.localUser.userId,
            }

            await axios.post("/history", history).then((res) => {
                //如果操作成功，关闭弹层，显示数据
                console.log(res.data.data);
                if (res.data.code === 20011) {
                    history.historyId = res.data.data;
                }
            }).catch(error => {
                console.error(error);
            });

            this.histories.push(history);
            this.modalVisible = false;
            this.historyInput = '';
        },
        cancel() {
            this.modalVisible = false;
            this.historyInput = '';
            this.stopTextToType();
        },

        //打字
        startTextToType(text) {
            this.textToType = text;
            this.typedText = "";
            this.index = 0;
            this.typeText();
        },
        stopTextToType() {
            this.textToType = "";
            this.typedText = "";
            this.index = 0;
        },
        typeText() {
            if (this.index < this.textToType.length) {
                this.typedText += this.textToType[this.index];
                this.index++;
                setTimeout(this.typeText, 100); // 调整打字速度
            }
        },

        //websocket
        connect() {
            //headers: 消息的头信息，表示为一个JavaScript对象。在这个例子中，我们传递一个空对象{}，表示没有额外的头信息。
            this.stompClient.connect({}, this.onConnected, this.onError);
        },
        onConnected() {
            this.stompClient.subscribe('/topic/messages', this.onMessageReceived);
        },
        onMessageReceived(payload) {
            this.receivedMessages.text += (JSON.parse(payload.body).content);
            // this.messages.push({text: JSON.parse(payload.body).content, isMine: false});
        },
        sendMessage() {
            if (this.inputText.trim()) {
                this.messages.push({text: this.inputText.trim(), isMine: true});
                this.stompClient.send('/app/send', {},
                    JSON.stringify(
                        {
                            content: this.inputText.trim(),
                            userId: this.localUser.userId
                        }
                    ));
                this.inputText = '';
                this.receivedMessages = {
                    text: '',
                    isMine: false
                }
                this.messages.push(this.receivedMessages);

                this.$nextTick(() => {
                    this.scrollToBottom();
                });
            }
        },
        onError() {
            console.error('WebSocket连接失败');
        },

        //删除历史记录
        deleteHistory() {
            this.histories.splice(this.confirmIndex, 1);
            this.showConfirm = false;

            if (this.histories.length > 0) {
                // 如果还有历史记录，更新 selectedHistory 为下一个记录的索引，或在删除最后一个记录时为上一个记录的索引
                this.selectedHistory = Math.min(this.confirmIndex, this.histories.length - 1);
                this.selectHistory(this.selectedHistory);
            } else {
                // 如果没有历史记录，将 selectedHistory 设为 null
                this.selectedHistory = null;
            }
        },

        //删除所有历史
        showAndHideDeleteAllHistories() {
            this.showDeleteAllHistories = true;
            setTimeout(() => {
                this.showDeleteAllHistories = false;
            }, 3000); // 3000 毫秒 = 3 秒
        },
        deleteAllHistories() {
            this.showDeleteAllHistories = false;
            this.histories.splice(0, this.histories.length);
            this.selectedHistory = null;
        },

        //编辑历史名字
        toggleEditHistoryName() {
            this.showEditHistoryName = !this.showEditHistoryName;
            this.editedHistoryName = this.histories[this.selectedHistory].historyName;
        },
        updateHistoryName() {
            this.histories[this.selectedHistory].historyName = this.editedHistoryName;
            this.showEditHistoryName = false;
        },
    },

});