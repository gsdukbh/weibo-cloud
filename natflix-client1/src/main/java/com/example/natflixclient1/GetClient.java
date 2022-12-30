package com.example.natflixclient1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Li JiaWei
 * @version TODO
 * @date 2022/12/30
 * @since on
 */
@FeignClient("client1")
public interface GetClient {

    @GetMapping("/his")
    String his();
}
