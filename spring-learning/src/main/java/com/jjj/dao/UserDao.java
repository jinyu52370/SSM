package com.jjj.dao;

import com.jjj.entity.User;
import config.SpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/7 17:22
 */
@Repository
public class UserDao extends BaseDao<User>{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void insert() {
        System.out.println("insert user");
    }

    public void pay(Double pay, String name){
        String sql = "UPDATE user SET money=money-? WHERE name = ?";
        jdbcTemplate.update(sql, pay, name);
    }

    public void proceed(Double proceed, String name){
        String sql = "UPDATE user SET money=money+? WHERE name = ?";
        jdbcTemplate.update(sql, proceed, name);
    }

    public Double queryMoney(String name){
        String sql = "SELECT money FROM user WHERE name = ?";
        Object money = jdbcTemplate.queryForList(sql, name).get(0).get("money");
        return new BigDecimal(String.valueOf(money)).doubleValue();
    }

    public void updateMoneyByName(Double money, String name){
        String sql = "UPDATE user SET money=? WHERE name = ?";
        jdbcTemplate.update(sql, money, name);
    }
}
