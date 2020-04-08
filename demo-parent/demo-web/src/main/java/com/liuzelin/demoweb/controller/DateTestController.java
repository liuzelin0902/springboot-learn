package com.liuzelin.demoweb.controller;

import com.liuzelin.demoservice.service.DateTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dateTest")
public class DateTestController {

    @Autowired
    private DateTestService dateTestService;

    @GetMapping("sayDate")
    public Object sayDate() {
        return dateTestService.sayDate();
    }
}
