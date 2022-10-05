package com.pabi.pabiuser.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(path = "/test")
    public String test(){
        System.out.println("test");
        return "test";
    }
}
