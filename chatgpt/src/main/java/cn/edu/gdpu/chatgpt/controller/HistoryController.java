package cn.edu.gdpu.chatgpt.controller;

import cn.edu.gdpu.chatgpt.controller.assist.Code;
import cn.edu.gdpu.chatgpt.controller.assist.Result;
import cn.edu.gdpu.chatgpt.domain.History;
import cn.edu.gdpu.chatgpt.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    /**
     * 获取所有的历史记录
     * 把所有的历史记录存到session
     *
     * 之后用户可以点击某个历史记录，携带历史记录的id过来后端，
     * 后端可以识别用户点击了哪一个历史记录，
     * 从而对消息列表List<ChatMessage>初始化
     */
    @GetMapping("/{userId}")
    public Result getAllHistoryByUserId(@PathVariable Integer userId, HttpSession session) {
        System.out.println(userId);
        List<History> histories = historyService.getHistoryAndAiPromptByUserId(userId);
        session.setAttribute("histories", histories);
        return new Result(Code.GET_OK, histories, "success");
    }


    /**
     * 插入一条记录
     */
    @PostMapping
    public Result saveHistory(@RequestBody History history) {
        System.out.println("saveHistory start...");
        System.out.println(history);
        int i = historyService.insertHistoryByObject(history);
        System.out.println(history.getHistoryId());
        System.out.println("saveHistory end...");
        return new Result(Code.SAVE_OK, history.getHistoryId(), "success");
    }



}