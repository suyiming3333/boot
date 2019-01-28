package com.sym.myboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/index2")
    public String index(){
        int i = 1/0;
        return "this is index2";
    }
}
