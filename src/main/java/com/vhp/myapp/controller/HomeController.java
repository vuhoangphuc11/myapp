package com.vhp.myapp.controller;

import com.vhp.myapp.service.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @Autowired
    CustomOAuth2UserService customOAuth2UserService;

    @GetMapping( "/app/login" )
    public String login() {
        return "login";
    }
    @GetMapping( "/app/logout" )
    public String logout() {
        return "login";
    }
    @GetMapping( "/hello" )
    public String home() {
        return "hello";
    }
}