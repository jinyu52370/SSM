package com.jjj.mything.service.impl;

import com.jjj.mything.service.Mything;
import org.springframework.stereotype.Service;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @description
 * @date 2019/10/9 21:44
 */
@Service
public class MythingImpl implements Mything {
    @Override
    public void visit(){
        try {
            System.out.println("旅游");
//            if (true){
//                throw new RuntimeException("意外");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
//        return 0;
    }
}
