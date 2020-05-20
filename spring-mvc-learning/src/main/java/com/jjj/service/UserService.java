package com.jjj.service;

import com.jjj.dao.UserDao;
import com.jjj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/14 14:32
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void updateUser(User user){
        userDao.updateUser(user);
    }
}
