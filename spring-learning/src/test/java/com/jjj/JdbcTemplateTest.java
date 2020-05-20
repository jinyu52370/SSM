package com.jjj;

import com.jjj.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/5 22:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = config.SpringConfig.class)
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void insertTest(){
        String sql = "INSERT INTO user (name,age,birthday,password,money,address) VALUES('JJJ2',123,NOW(),'123123',11,'西安')";
        jdbcTemplate.execute(sql);
    }

    @Test
    public void batchInsertTest(){
        String sql = "INSERT INTO user (name,age,birthday,password,money,address) VALUES(?, ?, ?, ?, ?, ?)";
        List<Object[]> batchArgs = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            batchArgs.add(new Object[]{"jjj" + i, i, new Date(), "pwd" + i, (double)i * 100, "西安" + i});
        }
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    @Test
    public void queryTest(){
//        String sql = "SELECT * FROM user WHERE NAME = 'jjj'";
        String sql = "SELECT MAX(id) FROM user";
        System.out.println(jdbcTemplate.queryForList(sql));
    }

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * 占位符参数: ?
     * 具名参数: :参数名
     */
    @Test
    public void queryTest1(){
        String sql = "SELECT * FROM user WHERE id = ?";
        System.out.println(jdbcTemplate.queryForList(sql, 27));

        String sql1 = "SELECT * FROM user WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", 27);
        System.out.println(namedParameterJdbcTemplate.queryForList(sql1, paramMap));

        String sql2 = "SELECT * FROM user WHERE id = :id";
        System.out.println(namedParameterJdbcTemplate.queryForList(sql2, new BeanPropertySqlParameterSource(
                new User().setId(27))
        ));
    }
}
