package com.kevin.controller;

import com.kevin.cloudshop.domain.ResultPac;
import com.kevin.cloudshop.domain.ResultState;
import com.kevin.domain.Store;
import com.kevin.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kevin2
 */
@RestController
@RequestMapping("store")
public class StoreController {
    @Autowired
    StoreService service;

    /**
     * 添加仓库
     */
    @PostMapping
    public ResultPac addStore(Store store) {
        boolean save = service.save(store);
        if (save) {
            return new ResultPac(1, ResultState.Success, null);
        } else {
            return new ResultPac(-1, ResultState.Fault, null);
        }
    }

    /**
     * 库存变动
     */
    @PutMapping
    public ResultPac updateStore(Long id,Integer change) {
        Store store = service.getById(id);
        store.setNum(store.getNum()+change);
        boolean update = service.updateById(store);
        if (update) {
            return new ResultPac(1, ResultState.Success, null);
        } else {
            return new ResultPac(-1, ResultState.Fault, null);
        }
    }

    @GetMapping("getAll")
    public ResultPac getStores() {
        List<Store> list = service.list();
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
