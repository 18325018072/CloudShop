package com.kevin.client;

import com.kevin.cloudshop.domain.ResultPac;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Kevin2
 */
@FeignClient(value = "orderServe",path = "order")
@Component
public interface OrderClient {
    @PostMapping
    ResultPac addOrder(@RequestParam Long userId, @RequestParam Long storeId, @RequestParam Integer num);
}
