package com.jjj.component;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/24 22:02
 */
@ResponseStatus(reason = "用户名错误，拒绝登录", value = HttpStatus.NOT_FOUND)
public class UserNameNotFoundException extends RuntimeException {
    public UserNameNotFoundException(String message) {
        super(message);
    }
}
