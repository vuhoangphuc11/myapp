package com.vhp.myapp.controller;

import com.vhp.myapp.service.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    CustomOAuth2UserService customOAuth2UserService;

    @GetMapping( "/home" )
    public String home() {
        return "test";
    }
}