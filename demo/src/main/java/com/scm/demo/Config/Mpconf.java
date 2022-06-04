package com.scm.demo.Config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.stat.DruidSpringAopConfiguration;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.scm.demo.Controller.Mylanjieqi;
import com.scm.demo.Pojo.Book;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//@EnableConfigurationProperties(xxx.class) 强制把某个类加载成bean
@Configuration(proxyBeanMethods = true)//true的话走代理增强方法@Bean的方法返回如果IOC容器存在该类型直接返回，不存在new一个放入容器。false 不走代理执行普通代码，每次都会新建一个对象
//@EnableCaching//启用缓存 配置中能被扫描到就可以
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableScheduling
//@PropertySource("huangju.properties")//加载properties文件到spring,springboot 项目不需要直接在默认配置文件写就可以了
public class Mpconf implements WebMvcConfigurer {//加载过滤器
    @Autowired
    Mylanjieqi mylanjieqi;
    @Bean //方法名就是生产的bean的id
    public MybatisPlusInterceptor interceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return mybatisPlusInterceptor;
    }
/**
 * 加载拦截器
 */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mylanjieqi).addPathPatterns("/books/*","/books");//拦截books以及之下url的请求
    }
//    aop配置
//    @Pointcut("execution(* com.scm..*.*(..))")
//    private void pt(){ }
//
//    @Around("Mpconf.pt()")
//    public Object maker(ProceedingJoinPoint point) throws Throwable {
//        System.out.println("12312132");
//        Object[] args = point.getArgs();
//        String arg = (String) args[1];
//        args[1]=arg.trim();
//        Object proceed = point.proceed(args);
//        return proceed;
//    }
  @Bean

//  @ConditionalOnMissingClass("com.scm.demo.Rest") Condition条件如果没有这个class文件就加载方法里面的bean可以注解在类上
//  @ConditionalOnClass 如果有这个class文件就加载方法里面的bean
//  @ConditionalOnBean 如果IOC容器有这个bean文件就加载方法里面的bean
    public String str(){
        return "";
  }
//  @Bean
//    public DruidDataSource druidDataSource(){
//        DruidDataSource dataSource=new DruidDataSource();
//        dataSource.setUrl("jdbc:mysql://localhost:3306/springtest");
//        dataSource.setUsername();
//      dataSource.setPassword();
//      dataSource.setDriverClassName();
//      dataSource.setMaxActive(10);
//        return dataSource;
//  }
//    @Bean
//    public ThreadPoolExecutor threadPoolExecutor(){
//        int coresize=2;
//        int maxsize=10;
//        return   new ThreadPoolExecutor(coresize, maxsize, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(), new RejectedExecutionHandler() {
//            @Override
//            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//
//            }
//        });
//
//    }
    @Bean
    public Book book(){
        return new Book();
    }

}
