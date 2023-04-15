package cn.edu.gdpu.chatgpt.mbg;

import cn.edu.gdpu.chatgpt.dao.UserMapper;
import cn.edu.gdpu.chatgpt.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MBG {

    @Autowired
    private UserMapper mapper;

    @Test
    public void testMBG(){
        User user = mapper.selectById(1);
        System.out.println(user);
    }
}
