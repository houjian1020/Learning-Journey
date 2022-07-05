package com.springboot.demo.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        return "hello11";
    }

}