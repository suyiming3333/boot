package com.sym.myboot.controller;

import com.sym.myboot.entity.User;
import com.sym.myboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public String createUser(){
        userService.createUser("10086","corn",18);
        return "success";
    }

    @RequestMapping("/saveUser")
    public String saveUser(){
        userService.saveUser();
        return "ok";
    }

    @RequestMapping("/selectAll")
    public List<User> selectAll(){
        List<User> list = userService.selectAll2();
        return list;
    }
}
