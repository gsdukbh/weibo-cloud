package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created on  2021/9/14
 *
 * @author leejiawei
 */
@RestController
@RequestMapping("/demo")
public class WebController {

    @Value("${foo}")
    private String name ;
    @GetMapping("/")
    public  String hi(){
        return name;
    }

}
