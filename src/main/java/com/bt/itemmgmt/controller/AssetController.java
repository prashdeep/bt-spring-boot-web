package com.bt.itemmgmt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/assets/")
public class AssetController {

    @GetMapping
    public String greet(){
        return "Rest API for greet message";
    }
}