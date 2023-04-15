package cn.edu.gdpu.chatgpt.dao;

import cn.edu.gdpu.chatgpt.domain.History;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class HistoryMapperTest {
    @Autowired
    private HistoryMapper historyMapper;

    @Test
    public void getHistoryAndAiPromptByUserId() {
        List<History> histories = historyMapper.getHistoryAndAiPromptByUserId(1);
        histories.forEach(System.out::println);
    }
}
