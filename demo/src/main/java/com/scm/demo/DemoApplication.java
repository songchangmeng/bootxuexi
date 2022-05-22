package com.scm.demo;

import com.scm.demo.Pojo.Test;
import com.scm.demo.mapper.BookMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@MapperScan("com.scm.demo.mapper")
@EnableConfigurationProperties(Test.class)//把@ConfigurationProperties注解的类添加到spring容器里

public class DemoApplication {

//    @Bean
//    public static Test test(){
//        Test test = new Test();
//        test.setMaker("scm");
//        test.setName("scm");
//        return test;
//    }
    public static void main(String[] args) {
//System.out.println("123");
//        System.out.println("456");
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        Test bean = context.getBean(Test.class);
        System.out.println(bean.toString());
        BookMapper bean1 = context.getBean(BookMapper.class);
        System.out.println(bean1.toString());
//        context.getBean(String.class);
    //    System.out.println( context.getBean(String.class).toString());
    }

}
