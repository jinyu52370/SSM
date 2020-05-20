package com.jjj.service;

import com.jjj.dao.UserDao;
import com.jjj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.format.SignStyle;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/7 17:22
 */
@Service
public class UserService extends BaseService<User>{
//    @Autowired
//    UserDao userDao;
//
//    public void insert(){
//        userDao.insert();
//    }

    @Autowired
    UserDao userDao;

    /**
     * 有事务的业务逻辑，容器中保存的是这个业务逻辑的代理对象
     *
     * System.out.println(userService.getClass());
     * ->
     * class com.jjj.service.UserService$$EnhancerBySpringCGLIB$$50611f85
     */
    @Transactional(
            timeout = 3,
            readOnly = false,
            noRollbackFor = {ArithmeticException.class},
            rollbackFor = {FileNotFoundException.class},
            propagation = Propagation.REQUIRES_NEW
    )
    public void transfer(Double money, String sourceUserName, String targetUserName){
        userDao.pay(money, sourceUserName);
        userDao.proceed(money, targetUserName);
//        int i = 1/0;
//        throw new RuntimeException();
//        new FileInputStream("asdadas.txt");
    }

    @Transactional(
            readOnly = true,
            isolation = Isolation.READ_UNCOMMITTED
    )
    public Double queryMoney(String name) {
        return userDao.queryMoney(name);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateMoneyByName(Double money, String name) {
        userDao.updateMoneyByName(money, name);
//        int i = 1/0;
    }
}
