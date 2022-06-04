package com.scm.demo.CallbackTest;

public class newcall implements Callbock{
    @Override
    public void success(int a) {
        System.out.println("success"+a);
    }

    @Override
    public void fail() {
        System.out.println("fail");
    }
}
