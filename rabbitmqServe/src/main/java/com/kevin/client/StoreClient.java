package com.kevin.client;

import com.kevin.cloudshop.domain.ResultPac;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Kevin2
 */
@FeignClient(value = "storeServe",path = "store")
@Component
public interface StoreClient {
    /**
     * 库存变动
     */
    @PutMapping
    ResultPac updateStore(@RequestParam Long id, @RequestParam Integer change);
}
