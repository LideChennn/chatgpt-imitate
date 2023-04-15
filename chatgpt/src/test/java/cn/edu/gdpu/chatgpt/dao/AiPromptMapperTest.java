package cn.edu.gdpu.chatgpt.dao;

import cn.edu.gdpu.chatgpt.domain.AiPrompt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AiPromptMapperTest {

    @Autowired
    private AiPromptMapper aiPromptMapper;


    @Test
    public void selectByPromptIdInt(){
        System.out.println(aiPromptMapper.selectByPromptIdInt(1));
    }

    @Test
    public void selectAll(){
        List<AiPrompt> prompts = aiPromptMapper.selectByExample(null);
        prompts.forEach(System.out::println);
    }



}
