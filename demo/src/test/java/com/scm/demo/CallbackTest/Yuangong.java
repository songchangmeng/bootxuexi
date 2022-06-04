package com.scm.demo.CallbackTest;

public class Yuangong {
    public void doit(Callbock callbock,int a,int b){
        if (a==b)
        callbock.success(a);
        else
        callbock.fail();
    }
}
