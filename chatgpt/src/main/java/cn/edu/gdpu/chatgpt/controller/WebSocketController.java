package cn.edu.gdpu.chatgpt.controller;

import cn.edu.gdpu.chatgpt.domain.IncomingMessage;
import cn.edu.gdpu.chatgpt.domain.Message;
import cn.edu.gdpu.chatgpt.service.ChatGPTService;
import com.theokanning.openai.completion.chat.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/**
 * 这个WebSocket控制器的作用是处理客户端发送的/app/send WebSocket消息，
 * 并将处理后的消息发送给所有订阅了/topic/messages目的地的客户端。
 */
@Controller
public class WebSocketController {

    @Autowired
    private ChatGPTService chatGPTService;

    @Autowired
    private ConcurrentMap<Integer, List<ChatMessage>> chatMessagesMap;

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public void handleMessage(@Payload IncomingMessage message) {
        System.out.println("WebSocketController start ...");
        System.out.println(message);
        //获取用户对应的聊天记录
        chatMessagesMap.get(message.getUserId());
        List<ChatMessage> chatMessages = chatMessagesMap.get(message.getUserId());
        chatMessages.forEach(System.out::println);
        chatMessages.add(new ChatMessage("user", message.getContent()));
        //流回复
        String aiResponse = chatGPTService.getChatGPTResponseUseStream(chatMessages);
        //添加到信息队列
        chatMessages.add(new ChatMessage("assistant", aiResponse));
        System.out.println(aiResponse);
        System.out.println("WebSocketController end ...");
    }
}
