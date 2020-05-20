package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/4 10:10
 */
@Configuration
@Import(value = {UserConfig.class, StudentConfig.class, AirConfig.class, AopConfig.class, DaoConfig.class})
@ComponentScan(basePackages = {"com.jjj"})
public class SpringConfig {

}
