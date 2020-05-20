package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/5 12:08
 *
 * 1.将目标类和切面类加入IOC容器
 * 2.告诉spring哪个是切面类
 * 3.告诉spring每个通知方法的执行区域(like @Before)
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

}
