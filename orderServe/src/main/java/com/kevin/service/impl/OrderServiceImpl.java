package com.kevin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevin.domain.Order;
import com.kevin.service.OrderService;
import com.kevin.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author 20349
* @description 针对表【order】的数据库操作Service实现
* @createDate 2022-08-06 12:58:47
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




