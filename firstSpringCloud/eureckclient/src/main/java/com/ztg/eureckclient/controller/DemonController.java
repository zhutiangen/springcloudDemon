package com.ztg.eureckclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/eureckclient")
public class DemonController {

    @Value(value = "${server.port}")
    private String port;

    @RequestMapping(value = "/test")
    public String demon() {

        return DemonController.class.getName() + ",port:" + this.port;
    }
}
