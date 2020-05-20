package config;

import com.jjj.entity.Student;
import com.jjj.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/4 10:16
 */
@Configuration
public class StudentConfig {
    @Bean
    public Student student() {
        Map<String, Integer> map = new HashMap<>(16);
        map.put("key1", 1);
        map.put("key2", 2);

        Student student = new Student();
        student.setUser(new User()
                .setId(100)
                .setName("hhh")
                .setAge(99))
                .setSchool("仙宫")
                .setClasses(Arrays.asList("高数","java")).setUsers(map);
        return student;
    }
}
