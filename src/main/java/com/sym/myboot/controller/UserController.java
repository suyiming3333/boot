package com.sym.myboot.controller;

import com.sym.myboot.entity.User;
import com.sym.myboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        List<User> list = userService.selectAll1();
        return list;
    }

    @RequestMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id") String id){
        System.out.println("id:"+id);
        User user = userService.getUserById(id);
        return user;
    }

    @RequestMapping("/updateUserById")
    public void updateUserById(){
        User user = new User();
        user.setAge(20);
        user.setId("1");
        user.setName("bilibili023");
        user.setType("0");
        userService.updateUserById(user);
    }


}
