package com.scm.demo.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Transactional(rollbackFor = Exception.class)
public interface AoptestService {
    Boolean pass(String url, String password);
    void zhuanzhang(String out,String in,int money) throws IOException;
}
