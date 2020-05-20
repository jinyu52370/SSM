package config;

import com.jjj.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/4 10:15
 */
@Configuration
@Import(value = {DateFormatConfig.class})
public class UserConfig {
    @Resource
    SimpleDateFormat dateFormat;

    @Bean
    public User user() throws ParseException {
        User user = new User();
        user.setId(0)
                .setName("jjj")
                .setAge(100)
                .setBirthday(dateFormat.parse("1999-05-07"))
                .setPassword("root")
                .setMoney(100.3)
                .setAddress("xian");
        return user;
    }

    @Bean
    public User user1() {
        return new User().setName("user1");
    }

    @Bean(initMethod = "myInit", destroyMethod = "myDestroy")
    public User userLifeCycle(){
        return new User();
    }

    @Bean(initMethod = "myInit", destroyMethod = "myDestroy")
    public User userLifeCyclePrototype(){
        return new User();
    }
}
