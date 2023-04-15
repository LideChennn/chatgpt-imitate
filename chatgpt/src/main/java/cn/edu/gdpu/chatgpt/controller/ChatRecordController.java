package cn.edu.gdpu.chatgpt.controller;

import cn.edu.gdpu.chatgpt.controller.assist.Code;
import cn.edu.gdpu.chatgpt.controller.assist.Result;
import cn.edu.gdpu.chatgpt.domain.ChatRecord;
import cn.edu.gdpu.chatgpt.domain.History;
import cn.edu.gdpu.chatgpt.domain.User;
import cn.edu.gdpu.chatgpt.service.HistoryService;
import cn.edu.gdpu.chatgpt.service.RecordService;
import com.theokanning.openai.completion.chat.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/record")
public class ChatRecordController {
    @Autowired
    private ConcurrentMap<Integer,List<ChatMessage>> chatMessagesMap;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private RecordService recordService;

    /**
     * 根据历史记录的id获取聊天记录
     * 顺便初始化List<ChatMessage>
     * 把ChatMessage添加
     * @param historyId 前端传过来
     * @return result
     */
    @GetMapping("/{historyId}")
    public Result getRecordAndAiResponseByHistoryId(@PathVariable Integer historyId, HttpSession session) {
        System.out.println("record start...");
        //对话信息
        List<ChatRecord> messages = recordService.getRecordAndAiResponseByHistoryId(historyId);

        //消息List<ChatMessage>
        List<ChatMessage> chatMessages = new LinkedList<>();

        //找到历史记录的prompt
        History history = historyService.getHistoryByHistoryId(historyId);
        if (history.getUserAiPrompt() != null) {
            //如果有用户的自定义参数
            chatMessages.add(new ChatMessage("system", history.getUserAiPrompt()));
        } else {
            chatMessages.add(new ChatMessage("system", history.getAiPrompt().getContent()));
        }

        //添加聊天记录
        for (ChatRecord message : messages) {
            chatMessages.add(new ChatMessage("user", message.getContent()));
            chatMessages.add(new ChatMessage("assistant", message.getAiResponse().getContent()));
        }
        //添加聊天列表消息到session
        chatMessagesMap.put(((User)session.getAttribute("user")).getUserId(),  chatMessages);
        chatMessages.forEach(System.out::println);
        System.out.println("record end...");
        //封装返回结果
        return new Result(Code.GET_OK, messages, "success");
    }
}