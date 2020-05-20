package com.jjj.dao;

import com.jjj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/18 16:04
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> queryAll(){
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    public User queryById(Integer id){
        String sql = "SELECT * FROM user WHERE id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), id).get(0);
    }

    public int addUser(User user){
        String sql = "INSERT INTO user (name,age,birthday,password,money,address) VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,
                user.getName(),
                user.getAge(),
                user.getBirthday(),
                user.getPassword(),
                user.getMoney(),
                user.getAddress());
    }

    public int updateUser(User user){
        String sql = "UPDATE user SET name=?,age=?,birthday=?,password=?,money=?,address=? WHERE id=?";
        return jdbcTemplate.update(sql,
                user.getName(),
                user.getAge(),
                user.getBirthday(),
                user.getPassword(),
                user.getMoney(),
                user.getAddress(),
                user.getId());
    }

    public int deleteUser(Integer id){
        String sql = "DELETE FROM user WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
