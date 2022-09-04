package com.terry.springbootmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
    @GetMapping
    public String home(){
        return "index";
    }
}
