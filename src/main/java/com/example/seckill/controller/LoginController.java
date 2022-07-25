package com.example.seckill.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {
    /**
     * redirecting sign-in page
     * */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }
}
