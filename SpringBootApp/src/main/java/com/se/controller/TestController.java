package com.se.controller;

import com.se.entity.Test;
import com.se.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @RequestMapping("/login")
//    public List<Test> login() {
//        return testService.queryById();
//    }
}
