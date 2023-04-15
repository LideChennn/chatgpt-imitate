package cn.edu.gdpu.chatgpt.service.impl;

import cn.edu.gdpu.chatgpt.dao.ChatRecordMapper;
import cn.edu.gdpu.chatgpt.domain.ChatRecord;
import cn.edu.gdpu.chatgpt.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private ChatRecordMapper chatRecordMapper;

    @Override
    public List<ChatRecord> getRecordAndAiResponseByHistoryId(Integer historyId) {
        return chatRecordMapper.getRecordAndAiResponseByHistoryId(historyId);
    }
}
