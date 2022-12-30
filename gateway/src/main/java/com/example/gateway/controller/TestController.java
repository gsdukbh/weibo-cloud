package com.example.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li JiaWei
 * @version TODO
 * @date 2022/12/16
 * @since on
 */
@RestController

public class TestController {


    @GetMapping("/de")
    public String token(){
        return "asdas";
    }

//    @GetMapping("/login")
    public String login( String username ,String passwd){
        return  "login";
    }

}
