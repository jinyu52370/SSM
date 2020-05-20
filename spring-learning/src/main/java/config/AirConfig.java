package config;

import com.jjj.entity.Air;
import com.jjj.factory.AirFactoryBeanImpl;
import com.jjj.factory.AirInstanceFactory;
import com.jjj.factory.AirStaticFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/4 10:16
 */
@Configuration
public class AirConfig {
    //region 静态工厂
    @Bean(name = "air1")
    public Air airStaticFactory(){
        return AirStaticFactory.getAir("air1的机长");
    }
    //endregion

    //region 实例工厂
    @Bean
    public AirInstanceFactory airInstanceFactory(){
        return new AirInstanceFactory();
    }

    @Bean(name = "air2")
    public Air air2(){
        return airInstanceFactory().getAir("air2的机长");
    }
    //endregion

    //region FactoryBean
    @Bean
    public AirFactoryBeanImpl airFactoryBeanImpl(){
        return new AirFactoryBeanImpl();
    }
    //endregion
}
