package cn.edu.gdpu.chatgpt.controller;

import cn.edu.gdpu.chatgpt.controller.assist.Code;
import cn.edu.gdpu.chatgpt.controller.assist.Result;
import cn.edu.gdpu.chatgpt.domain.History;
import cn.edu.gdpu.chatgpt.domain.User;
import cn.edu.gdpu.chatgpt.service.HistoryService;
import cn.edu.gdpu.chatgpt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录逻辑
     */
    @RequestMapping("/login")
    public Result login(@RequestBody User user, HttpSession session) {

        User user1 = userService.login(user);
        boolean isSuccess = user1 != null;
        //登录成功就存到session
        if (isSuccess) {
            session.setAttribute("user", user);
        }

        return  new Result(isSuccess ? Code.GET_OK : Code.GET_ERR,
                isSuccess,
                isSuccess? "登录成功" : "账户或密码错误");
    }

    /**
     * 通过session获取用户的信息
     */
    @RequestMapping("/getUser")
    public Result getUserBySession(HttpSession session) {
        return new Result(Code.GET_OK, session.getAttribute("user"));
    }
}