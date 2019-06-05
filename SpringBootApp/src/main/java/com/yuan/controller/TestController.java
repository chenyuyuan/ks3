package com.yuan.controller;

import com.yuan.entity.Test;
import com.yuan.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/query")
    public List<Test> testQuery() {
        return testService.queryById();
    }

    @RequestMapping("/test")
    public String test() {
        return "Hello";
    }

    @GetMapping
    @RequestMapping("/user")
    public String getUsers() {
        return "Hello Spring Security";
    }

    @GetMapping
    @RequestMapping("/login")
    public String login() {
        return "Hello Spring Security";
    }
}
