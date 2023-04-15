package cn.edu.gdpu.chatgpt.controller;

import cn.edu.gdpu.chatgpt.controller.assist.Code;
import cn.edu.gdpu.chatgpt.controller.assist.Result;
import cn.edu.gdpu.chatgpt.domain.AiPrompt;
import cn.edu.gdpu.chatgpt.service.AiPromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prompt")
public class AiPromptController {

    @Autowired
    private AiPromptService aiPromptService;

    /**
     * 获取所有的prompt，存到session
     * @return .
     */
    @GetMapping("/")
    public Result getAllPrompt() {
        List<AiPrompt> prompts = aiPromptService.getAllPrompt();
        return new Result(Code.GET_OK, null, "success");
    }
}
