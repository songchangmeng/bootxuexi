package com.scm.demo.Service.impl;

import com.scm.demo.Service.AoptestService;
import com.scm.demo.mapper.TranZhuangzhangDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AopServiceimpl implements AoptestService {
@Autowired
    TranZhuangzhangDao tranZhuangzhangDao;
    @Override
    public Boolean pass(String url, String password) {
       return password.equals("scm521");


    }

    @Override
    public void zhuanzhang(String out, String in, int money) throws IOException {
        tranZhuangzhangDao.zhaungzhangout(out,money);
//    int i=1/0;
        if (true) throw new IOException();
        tranZhuangzhangDao.zhaungzhangin(in,money);
    }
}
