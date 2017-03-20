package com.example.service;

import com.example.dao.mapper.UserMapper;
import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yanglikun on 2017/3/19.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void addUser(User user) {
        User user1 = new User();
        user1.setName("user-1");
        userMapper.save(user1);
        int i=1/0;
        User user2 = new User();
        user2.setName("user-2");
        userMapper.save(user2);
    }

    public User selectById(Long id) {
        return userMapper.selectById(id);
    }

}
