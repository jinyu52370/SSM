package com.jjj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/10 17:00
 */
@Service
public class MulService {
    @Autowired
    UserService userService;

    @Transactional
    public void mulTx() {
        userService.transfer(50.0, "jjj1", "jjj2");
        userService.updateMoneyByName(666.0, "jjj3");

        int i = 1/0;
    }
}
