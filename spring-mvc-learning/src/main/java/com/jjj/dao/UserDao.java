package com.jjj.dao;

import com.jjj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/14 14:33
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateUser(User user) {
        String sql = "UPDATE user SET age=?,birthday=?,password=?,money=?,address=? WHERE name=?";
        jdbcTemplate.update(sql,
                user.getAge(),
                user.getBirthday(),
                user.getPassword(),
                user.getMoney(),
                user.getAddress(),
                user.getName()
        );
    }
}   
