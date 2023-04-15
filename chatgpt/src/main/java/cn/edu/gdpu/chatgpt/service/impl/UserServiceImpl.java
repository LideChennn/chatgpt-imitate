package cn.edu.gdpu.chatgpt.service.impl;

import cn.edu.gdpu.chatgpt.dao.UserMapper;
import cn.edu.gdpu.chatgpt.domain.User;
import cn.edu.gdpu.chatgpt.domain.UserExample;
import cn.edu.gdpu.chatgpt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User login(User user) {
        UserExample userExample = new UserExample();


        UserExample.Criteria criteria = userExample.createCriteria();
        //添加条件，账户密码要匹配
        criteria.andUsernameEqualTo(user.getUsername())
                .andPasswordEqualTo(user.getPassword());

        List<User> users = userMapper.selectByExample(userExample);

        return users.get(0);
    }
}
