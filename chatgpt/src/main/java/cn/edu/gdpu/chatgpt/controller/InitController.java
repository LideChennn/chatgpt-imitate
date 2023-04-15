package cn.edu.gdpu.chatgpt.controller;

import cn.edu.gdpu.chatgpt.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/init")
public class InitController {
    @RequestMapping
    public String doInit(HttpSession httpSession) {
        httpSession.setAttribute("user", new User(1, "chenlide", "1234"));
        return "redirect:/pages/chatgpt.html";
    }
}
