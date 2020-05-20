package config;

import com.alibaba.druid.pool.DruidDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2019/10/10 10:03
 */
@PropertySource("classpath:jdbc.properties")
public class DaoConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

//    @Bean
//    @Scope("prototype")
//    public DruidDataSource dataSource(){
//        DruidDataSource ds = new DruidDataSource();
//        ds.setUrl(url);
//        ds.setDriverClassName(driverClassName);
//        ds.setUsername(username);
//        ds.setPassword(password);
//        return ds;
//    }

//    @Bean
//    public JdbcTemplate jdbcTemplate(){
//        return new JdbcTemplate(dataSource());
//    }

//    @Bean
//    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
//        return new NamedParameterJdbcTemplate(dataSource());
//    }

}
