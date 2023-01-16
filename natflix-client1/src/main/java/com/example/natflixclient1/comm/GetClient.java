package com.example.natflixclient1.comm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Li JiaWei
 * @version TODO
 * @date 2022/12/30
 * @since on
 */
@Component
@FeignClient("client1")
public interface GetClient {

    @GetMapping("/his")
    String his();
}
