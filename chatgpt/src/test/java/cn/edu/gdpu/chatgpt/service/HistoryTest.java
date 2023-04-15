package cn.edu.gdpu.chatgpt.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HistoryTest {
    @Autowired
    private HistoryService historyService;
    @Test
    public void  getHistoryByHistoryId() {
        System.out.println(historyService.getHistoryByHistoryId(1));
    }

}
