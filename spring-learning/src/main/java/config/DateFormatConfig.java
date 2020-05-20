package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/4 10:17
 */
@Configuration
public class DateFormatConfig {
    @Bean
    public SimpleDateFormat dateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd");
    }
}
