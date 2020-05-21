package com.jjj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;


import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/3 20:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class User {
    private Integer id;

    @NotEmpty
    @Length(min = 6, max = 18)
    private String name;

    private Integer age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @NotEmpty
    private String password;

    @NumberFormat(pattern = "#,###,###.##")
    private Double money;

    private String address;
}
