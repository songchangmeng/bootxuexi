package com.scm.demo.Config;

import com.scm.demo.mapper.TranZhuangzhangDao;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Aspect
public class Aopation {
    @Autowired
    TranZhuangzhangDao tranZhuangzhangDao;
    @Pointcut("execution(* com.scm..*.pass(..))")//实体类或者接口方法
    private void pt(){ }

    @Pointcut("execution(* com.scm..*.zhuan*(..))")
    private void shiwupt(){ }
//@Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")//标注注解的方法

    @Around("Aopation.pt()")
    public Object maker(ProceedingJoinPoint point) throws Throwable {
        System.out.println("12312132");
        Object[] args = point.getArgs();
        String arg = (String) args[1];
        args[1]=arg.trim();
        Object proceed = point.proceed(args);
        return proceed;
    }

    @Around("Aopation.shiwupt()")
    public Object makershiwu(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();//参数
        tranZhuangzhangDao.xinzheng("pgq",500);//动态代理，被代理类添加事务后异常发生回滚，这个方法增强的事务不想回滚就在mapper对应类加上声明新事物注解
        Object proceed = point.proceed();
        return proceed;
    }

}
