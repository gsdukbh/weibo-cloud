package com.example.gateway.controller;

import com.example.common.utils.JwtTokenUtils;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li JiaWei
 * @version TODO
 * @date 2022/12/16
 * @since on
 */
@RestController
@ComponentScan("com.example.common")
public class TestController {
    @Resource
    private JwtTokenUtils tokenUtils;

    @GetMapping("/de")
    public String token(){

        return  tokenUtils.generateToken("tken");

    }

}
