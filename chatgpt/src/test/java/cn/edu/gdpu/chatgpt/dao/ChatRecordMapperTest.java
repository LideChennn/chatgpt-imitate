package cn.edu.gdpu.chatgpt.dao;

import cn.edu.gdpu.chatgpt.domain.ChatRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ChatRecordMapperTest {
    @Autowired
    private ChatRecordMapper chatRecordMapper;

    @Test
    public void testGetRecordAndAiResponseByHistoryId() {
        List<ChatRecord> recordList = chatRecordMapper.getRecordAndAiResponseByHistoryId(1);
        recordList.forEach(System.out::println);
    }
}
