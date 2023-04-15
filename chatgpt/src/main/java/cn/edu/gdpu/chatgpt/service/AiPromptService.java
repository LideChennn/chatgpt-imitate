package cn.edu.gdpu.chatgpt.service;

import cn.edu.gdpu.chatgpt.domain.AiPrompt;

import java.util.List;

public interface AiPromptService {

    /**
     * 获取所有的prompt
     * @return List<AiPrompt>
     */
    List<AiPrompt> getAllPrompt();
}
