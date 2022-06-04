package com.scm.demo.Pojo;

import com.baomidou.mybatisplus.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
@TableName("book")
public class Book {
    @TableId(type = IdType.AUTO)//自增
    private  int id;
    @TableField("name")//数据库字段名 映射
    private String name;//实体属性名
//    @TableLogic
    private String maker;
//    @Value("${nickname}")
//    public String nickname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maker='" + maker + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setName(String name) {
        this.name = name;
    }
}
