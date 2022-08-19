package com.kevin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevin.domain.User;
import com.kevin.service.UserService;
import com.kevin.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 20349
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-08-06 12:57:50
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




