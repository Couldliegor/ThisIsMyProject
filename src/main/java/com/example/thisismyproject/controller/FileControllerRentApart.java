package com.example.thisismyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileControllerRentApart {
    @GetMapping("/")
    public String error() {
        return "Error";
    }
}
