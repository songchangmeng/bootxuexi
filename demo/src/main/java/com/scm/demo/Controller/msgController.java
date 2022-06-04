package com.scm.demo.Controller;

import com.scm.demo.utils.msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msg")
public class msgController {
    @Autowired
    msg msgs;
@GetMapping("getmsg")
    @CachePut(value = "msgcode",key = "#tel")//存缓存（key：参数，value：函数返回值），key相同覆盖返回值，
    public String getmsg(int tel){
    return String.valueOf((System.currentTimeMillis()%1000000));
}
@GetMapping("check")
    public Boolean cheak(int tel,String code){
    String cheak = msgs.cheak(tel, code);
    return code.equals(cheak);
}
}
