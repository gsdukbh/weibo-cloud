package com.example.natflixclient1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li JiaWei
 * @version TODO
 * @date 2022/12/30
 * @since on
 */
@RestController
public class DemoController {

    @GetMapping("/hi")
    public  String hi (){
        return  "this client1";
    }
}
