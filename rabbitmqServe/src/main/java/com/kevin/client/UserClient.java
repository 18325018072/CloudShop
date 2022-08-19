package com.kevin.client;

import com.kevin.cloudshop.domain.ResultPac;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Kevin2
 */
@FeignClient(value = "userServe",path = "user")
@Component
public interface UserClient {
    @PutMapping
    ResultPac addUserConsume(@RequestParam Long id, @RequestParam Integer consume);
}
