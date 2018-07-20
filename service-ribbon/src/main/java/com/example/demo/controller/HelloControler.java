package com.example.demo.controller;

import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello")
    public String hello(){
        return helloService.hiService();
    }
}
