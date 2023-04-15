package cn.edu.gdpu.chatgpt.service;

import cn.edu.gdpu.chatgpt.domain.ChatRecord;

import java.util.List;

public interface RecordService {
    /**
     * 根据历史id获取聊天记录（联合ai回复表）
     * @param historyId 历史id
     * @return List<ChatRecord>
     */
    List<ChatRecord> getRecordAndAiResponseByHistoryId(Integer historyId);
}
