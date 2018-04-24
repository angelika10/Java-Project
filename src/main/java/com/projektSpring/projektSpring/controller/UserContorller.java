package com.projektSpring.projektSpring.controller;

import com.projektSpring.projektSpring.domain.User;
import com.projektSpring.projektSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class UserContorller {

    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public String getUsers(Model model){
        List<User> allUsers = userService.getAllUser();
        model.addAttribute("users", allUsers);
        return "users";
    }
}
