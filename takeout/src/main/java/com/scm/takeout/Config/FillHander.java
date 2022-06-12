package com.scm.takeout.Config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.scm.takeout.utils.ThreadLocalHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * 自动填充，当表更新时 master
 */
@Component
public class FillHander implements MetaObjectHandler{
    @Autowired
    HttpServletRequest request;
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("自动填充数据 insert");
     metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("createUser", request.getSession().getAttribute("employee"));
        metaObject.setValue("updateUser", request.getSession().getAttribute("employee"));
//        metaObject.setValue("createUser", ThreadLocalHandler.getid());
//        metaObject.setValue("updateUser", ThreadLocalHandler.getid());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("自动填充数据 update");

        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("updateUser", ThreadLocalHandler.getid());
        ThreadLocalHandler.threadLocal.remove();
    }
}
