package com.example.thisismyproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {
    @RequestMapping("/")
    public String hello() {
        return "hello, world";
    }
}
