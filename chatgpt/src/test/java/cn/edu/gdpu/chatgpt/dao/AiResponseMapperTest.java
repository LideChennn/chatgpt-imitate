package cn.edu.gdpu.chatgpt.dao;

import cn.edu.gdpu.chatgpt.domain.AiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AiResponseMapperTest {
    @Autowired
    private AiResponseMapper aiResponseMapper;
    @Test
    public void testGetAiResponseByRecordId() {
        AiResponse response = aiResponseMapper.getAiResponseByRecordId(1);
        System.out.println(response);
    }
}
