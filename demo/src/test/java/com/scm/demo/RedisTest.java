package com.scm.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class RedisTest {
   public  List<Integer> i =new ArrayList<>();
   public static Boolean flag=false;
    public static Boolean flag1=false;
    class Mythread implements Runnable{

        @Override
        public void run() {
            synchronized (i){
            for (int j = 0; j <50 ; j++) {
                i.add(j);
                System.out.println(j);
                }
            }
    }}

    @Test
    void redisset(@Autowired RedisTemplate redisTemplate){
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("name","huangju");
    }
    @Test
    void redisget(@Autowired RedisTemplate redisTemplate){
        ValueOperations ops = redisTemplate.opsForValue();
        System.out.println(ops.get("name"));
    }
    @Test
    void redisset(@Autowired StringRedisTemplate redisTemplate){
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("name","huangju");
    }
    @Test
    void redisget(@Autowired StringRedisTemplate redisTemplate){
        ValueOperations ops = redisTemplate.opsForValue();
        System.out.println(ops.get("name"));
    }
    @Test
    void threadtest(){

//

        new Thread(new Mythread()).start();
        new Thread(new Mythread()).start();
        new Thread(new Mythread()).start();
        new Thread(new Mythread()).start();
        new Thread(new Mythread()).start();
        System.out.println("::::::::::::::::::");
    }
}
