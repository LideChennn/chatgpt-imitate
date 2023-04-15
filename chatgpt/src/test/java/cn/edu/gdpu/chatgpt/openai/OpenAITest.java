package cn.edu.gdpu.chatgpt.openai;

import cn.edu.gdpu.chatgpt.service.ChatGPTService;
import com.theokanning.openai.completion.chat.ChatMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootTest
public class OpenAITest {
    @Value("${openai.chatgpt.systemRole}")
    private String systemRole;
    @Autowired
    private ChatGPTService chatGPTService;
//    @Test
//    public void testChatGPT() {
//        List<ChatMessage> msgList = new ArrayList<>();
//        //系统的角色
//        msgList.add(new ChatMessage("system", systemRole));
//         //用户的信息
//        msgList.add(new ChatMessage("user", "你好"));
//        //获取回复
//        String chatGPTResponse = chatGPTService.getChatGPTResponse(msgList);
//        //把chatgpt回复的信息加入到信息队列
//        msgList.add(new ChatMessage("assistant", chatGPTResponse));
//        System.out.println(chatGPTResponse);
//    }

}
