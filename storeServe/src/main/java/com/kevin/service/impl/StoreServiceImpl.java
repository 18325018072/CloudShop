package com.kevin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevin.domain.Store;
import com.kevin.service.StoreService;
import com.kevin.mapper.StoreMapper;
import org.springframework.stereotype.Service;

/**
* @author 20349
* @description 针对表【store】的数据库操作Service实现
* @createDate 2022-08-06 12:58:29
*/
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store>
    implements StoreService{

}




