package com.scm.demo.CallbackTest;

import org.junit.jupiter.api.Test;

public class Boss {
    Callbock callbock;
    Yuangong yuangong;


    public void doit(Callbock callbock,Yuangong yuangong,int a,int b){
        yuangong.doit(callbock,a,b);
    }


    @Test
    void test(){
//        Boss boss = new Boss();
//        boss.doit(new Callbock() {
//            @Override
//            public void success() {
//                System.out.println("do it success");
//            }
//
//            @Override
//            public void fail() {
//                System.out.println("do it fail");
//            }
//        },new Yuangong(),1,1);
        Yuangong yuangong = new Yuangong();
        yuangong.doit(new Callbock() {
            @Override
            public void success(int a) {
                System.out.println("do it success");
            }

            @Override
            public void fail() {
                System.out.println("do it fail");
            }
        },1,1);

    }

}
