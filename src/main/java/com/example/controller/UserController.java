package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikun on 2017/3/19.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public String addUser(User user) {
        userService.addUser(user);
        return "add user";
    }

    @RequestMapping("/selectById")
    public String selectById(Long id) {
        User user = userService.selectById(id);
        System.out.println("user:" + user);
        return "selectById";
    }

}
