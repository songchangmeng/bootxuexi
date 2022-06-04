package com.scm.demo;

import com.scm.demo.Config.Mpconf;
import com.scm.demo.Pojo.Book;
import com.scm.demo.Pojo.Test;
import com.scm.demo.Service.AoptestService;
import com.scm.demo.mapper.BookMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@MapperScan("com.scm.demo.mapper")//可以不加@mapper，也可以加@mapper不加扫描
//@EnableConfigurationProperties(Test.class)//把@ConfigurationProperties注解的类添加到spring容器里 可以不使用@Component注解
//@ComponentScan("com.scm.demo.mapper") //如果@Component在主包内可以不加扫描
public class DemoApplication {

//    @Bean
//    public static Test test(){
//        Test test = new Test();
//        test.setMaker("scm");
//        test.setName("scm");
//        return test;
//    }
    public static void main(String[] args) {
        //加载配置类
//      AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(Mpconf.class);
//        BookMapper bean2 = applicationContext.getBean(BookMapper.class);
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        AoptestService bean = context.getBean(AoptestService.class);
        System.out.println(bean.getClass());//class com.scm.demo.Service.impl.AopServiceimpl$$EnhancerBySpringCGLIB$$8931ea5代理对象，不是原有写的imp对象

//        System.out.println(context.getBean(AoptestService.class));
//        Test bean = context.getBean(Test.class);
//        System.out.println(bean.toString());
//        BookMapper bean1 = context.getBean(BookMapper.class);
//        System.out.println(bean1.toString());


//        System.out.println(new Book().getName());
//        context.getBean(String.class);
    //    System.out.println( context.getBean(String.class).toString());
    }

}
