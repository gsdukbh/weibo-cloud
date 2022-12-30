package com.example.zookeeperdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li JiaWei
 * @version TODO
 * @date 2022/12/30
 * @since on
 */

@RestController
public class HelleWoController {

    @GetMapping("/hello")
    public  String hi(){
        return  " hello word zook";
    }
}
