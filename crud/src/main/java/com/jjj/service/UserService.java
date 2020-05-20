package com.jjj.service;

import com.jjj.dao.UserDao;
import com.jjj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/18 16:04
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> queryAll(){
        return userDao.queryAll();
    }

    public User queryById(Integer id){
        return userDao.queryById(id);
    }

    public int addUser(User user) {
        return userDao.addUser(user);
    }

    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    public int deleteUser(Integer id){
        return userDao.deleteUser(id);
    }
}
