package cn.edu.gdpu.chatgpt.service.impl;

import cn.edu.gdpu.chatgpt.dao.HistoryMapper;
import cn.edu.gdpu.chatgpt.domain.History;
import cn.edu.gdpu.chatgpt.domain.HistoryExample;
import cn.edu.gdpu.chatgpt.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public List<History> getHistoryAndAiPromptByUserId(Integer userId) {
        return historyMapper.getHistoryAndAiPromptByUserId(userId);
    }

    @Override
    public History getHistoryByHistoryId(Integer historyId) {
        HistoryExample historyExample = new HistoryExample();
        HistoryExample.Criteria criteria = historyExample.createCriteria();
        criteria.andHistoryIdEqualTo(historyId);
        return historyMapper.selectByExample(historyExample).get(0);
    }

    @Override
    public List<History> getAllByUserId(Integer userId) {
        HistoryExample historyExample = new HistoryExample();
        //设计条件为等于userId
        HistoryExample.Criteria criteria = historyExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return historyMapper.selectByExample(historyExample);
    }

    @Override
    public int insertHistoryByObject(History history) {
        return historyMapper.insertSelective(history);
    }
}
