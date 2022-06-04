package com.scm.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class Testconf {
//    @Bean
//    public String test2(){//方法名为bean id ，之前test名与Test类的bean id 重复。String为bean类型
//        return "test bean config";
//    }
    public  Object getins(Class clazz) throws InstantiationException, IllegalAccessException {
        return clazz.newInstance();
    }
}
