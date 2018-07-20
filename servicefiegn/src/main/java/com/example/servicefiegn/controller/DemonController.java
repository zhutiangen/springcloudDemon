package com.example.servicefiegn.controller;

import com.example.servicefiegn.myInterface.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemonController {

    @Autowired
    private SchedualServiceHi schedualServiceHi;

    @RequestMapping(value = "hi")
    public String demon() {
        return schedualServiceHi.sayHiFromClientOne();
    }

}
