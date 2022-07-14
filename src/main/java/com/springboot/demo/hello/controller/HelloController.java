package com.springboot.demo.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("test")
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        // 跳转到主页，只能使用Controller，不能使用RestController
        return "forward:/index.html";
    }

}
