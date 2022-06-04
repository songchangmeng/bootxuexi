package com.scm.demo.Controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.scm.demo.Pojo.Book;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//处理异常通知
public class ExceptionTestView {
@ExceptionHandler(Exception.class)//原控制器出现异常进入该方法执行，标注在控制器上方
    public String doException(Exception e){
    return JSON.toJSONString(new Book());
    }
}
