package cn.edu.gdpu.chatgpt.controller;

import cn.edu.gdpu.chatgpt.controller.assist.Code;
import cn.edu.gdpu.chatgpt.controller.assist.Result;
import cn.edu.gdpu.chatgpt.domain.User;
import cn.edu.gdpu.chatgpt.service.ChatGPTService;
import com.theokanning.openai.completion.chat.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/chat")
public class ChatGPTController {
    @Autowired
    private ConcurrentMap<Integer,List<ChatMessage>> chatMessagesMap;

    @Autowired
    private ChatGPTService chatGPTService;

    @Value("${openai.chatgpt.systemRole}")
    private String systemRole;

    /**
     *
     * @param msg 用户发送的聊天信息
     * @param session HttpSession
     * @return 聊天消息列表为空，返回错误码
     */
    @PostMapping("/doChat")
    public Result doChat(@RequestBody String msg, HttpSession session) {
        System.out.println("ChatGPTController start...");
        System.out.println("用户发送的信息是：" + msg);
        List<ChatMessage> chatMessages = chatMessagesMap.get(((User)session.getAttribute("user")).getUserId());
        chatMessages.forEach(System.out::println);

        //聊天消息列表不存在则返回错误信息
        if (chatMessages == null || chatMessages.size() == 0) {
            return new Result(Code.GET_ERR, null, "fail");
        }
        chatMessages.add(new ChatMessage("user", msg));
        String gptResponse = chatGPTService.getChatGPTResponse(chatMessages);
        chatMessages.add(new ChatMessage("assistant", gptResponse));
        System.out.println("ChatGPTController end...");
        return new Result(Code.GET_OK, gptResponse, "success");
    }
}