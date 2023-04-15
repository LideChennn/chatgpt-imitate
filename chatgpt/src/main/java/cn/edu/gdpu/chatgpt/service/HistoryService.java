package cn.edu.gdpu.chatgpt.service;

import cn.edu.gdpu.chatgpt.domain.History;

import java.util.List;

public interface HistoryService {

    /**
     * 分布查询，根据用户id获取历史记录及历史记录的prompt
     * @param userId 用户id
     * @return List<History>
     */
    List<History> getHistoryAndAiPromptByUserId(Integer userId);

    /**
     * 根据历史id搜索历史
     * @param historyId 历史id
     * @return History
     */
    History getHistoryByHistoryId(Integer historyId);

    /**
     * 根据id查询用户所有的历史聊天记录
     * @return .
     */
    List<History> getAllByUserId(Integer userId);

    /**
     * 添加历史聊天记录
     * 选择性添加，具有主键返回
     */
    int insertHistoryByObject(History history);
}
