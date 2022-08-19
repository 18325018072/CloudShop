package com.kevin.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.kevin.cloudshop.domain.ResultPac;
import com.kevin.cloudshop.domain.ResultState;
import com.kevin.domain.User;
import com.kevin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Kevin2
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService service;

    /**
     * 添加用户
     */
    @PostMapping
    public ResultPac addUser(@RequestParam("name") String name, @RequestParam("count") int count) {
        boolean save = service.save(new User(null, name, count));
        if (save) {
            return new ResultPac(1, ResultState.Success, null);
        } else {
            return new ResultPac(-1, ResultState.Fault, null);
        }
    }

    @PutMapping
    public ResultPac addUserConsume(Long id,Integer consume) {
        User user = service.getById(id);
        user.setCount(user.getCount()+consume);
        boolean update = service.updateById(user);
        if (update) {
            return new ResultPac(1, ResultState.Success, null);
        } else {
            return new ResultPac(-1, ResultState.Fault, null);
        }
    }

    @GetMapping("getAll")
    public ResultPac getAllUsers() {
        List<User> list = service.list();
        if (list != null) {
            return new ResultPac(1, ResultState.Success, list);
        } else {
            return new ResultPac(-1, ResultState.Fault, null);
        }
    }
    @DeleteMapping
    public ResultPac deleteById(Long id){
        boolean remove = service.removeById(id);
        if (remove) {
            return new ResultPac(1, ResultState.Success, null);
        } else {
            return new ResultPac(-1, ResultState.Fault, null);
        }
    }
}
