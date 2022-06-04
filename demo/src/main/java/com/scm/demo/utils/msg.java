package com.scm.demo.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class msg {
    @Cacheable(value = "msgcode",key = "#tel")//可存可取 如果空间存在key对应的value，返回value,否则返回null
    public String cheak(int tel ,String code){

        return null;
    }
}
