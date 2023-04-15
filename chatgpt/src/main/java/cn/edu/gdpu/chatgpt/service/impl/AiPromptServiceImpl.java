package cn.edu.gdpu.chatgpt.service.impl;

import cn.edu.gdpu.chatgpt.dao.AiPromptMapper;
import cn.edu.gdpu.chatgpt.domain.AiPrompt;
import cn.edu.gdpu.chatgpt.service.AiPromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AiPromptServiceImpl implements AiPromptService {

    @Autowired
    private AiPromptMapper aiPromptMapper;
    /**
     * 获取所有的prompt
     * @return List<AiPrompt>
     */
    @Override
    public List<AiPrompt> getAllPrompt() {
        return aiPromptMapper.selectByExample(null);
    }
}
