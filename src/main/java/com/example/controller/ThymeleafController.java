package com.example.controller;

import com.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yanglikun on 2017/3/15.
 */
@Controller
@RequestMapping("/tl")
public class ThymeleafController {

    @RequestMapping
    public String tl(Model model){
        User user1 = new User();
        user1.setName("name-1");
        user1.setAge(1);

        User user2 = new User();
        user2.setName("name-2");
        user2.setAge(2);
        List<User> users = Arrays.asList(user1, user2);

        model.addAttribute("users", users);
        model.addAttribute("user", user1);
        return "tl";
    }
}
