package com.vhp.myapp.controller;

import com.vhp.myapp.service.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping( "/login-success")
    public String LoginSucess() {
        return "loginSuccess";
    }
    @GetMapping("/403")
    public String Error() {
        return "403";
    }
}