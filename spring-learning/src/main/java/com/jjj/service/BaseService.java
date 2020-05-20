package com.jjj.service;

import com.jjj.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/7 17:26
 */
public class BaseService<T> {
    @Autowired
    BaseDao<T> baseDao;

    public void insert(){
        System.out.println("执行insert：" + baseDao);
        baseDao.insert();
    }
}
