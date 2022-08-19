package com.kevin.controller;

import com.kevin.cloudshop.domain.ResultPac;
import com.kevin.cloudshop.domain.ResultState;
import com.kevin.domain.Order;
import com.kevin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kevin2
 */
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService service;

    /**
     * 添加Order
     */
    @PostMapping
    public ResultPac addOrder(Long userId,Long storeId,Integer num) {
        boolean save = service.save(new Order(null,userId,storeId,num));
        if (save) {
            return new ResultPac(1, ResultState.Success, null);
        } else {
            return new ResultPac(-1, ResultState.Fault, null);
        }
    }

    @GetMapping("getAll")
    public ResultPac getAllOrders() {
        List<Order> list = service.list();
        if (list != null) {
            return new ResultPac(1, ResultState.Success, list);
        } else {
            return new ResultPac(-1, ResultState.Fault, null);
        }
    }
}
