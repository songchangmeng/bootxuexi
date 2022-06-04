package com.scm.demo;

import com.scm.demo.CallbackTest.Callbock;
import com.scm.demo.CallbackTest.newcall;
import com.scm.demo.Pojo.Book;
import com.scm.demo.Service.AoptestService;
import com.scm.demo.Service.BookService;
import com.scm.demo.Service.SendMail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

@SpringBootTest
public class Javatest {
    @Autowired
    SendMail sendMail;
    @Autowired
    AoptestService service;
@Autowired
    com.scm.demo.Pojo.Test test;
    @Test
    void test(){
        Integer integer=1;
        String format = String.format("%06d",integer); // 0 代表前面补充0
        // 6 代表长度为6
        // d 代表参数为正数型
        System.out.println(format);

    }
    @Test
    void tests() throws InstantiationException, IllegalAccessException {
//        System.out.println(new Testconf().getins(Book.class));
//        System.out.println(new Testconf().getins(new Book().getClass()));
//        System.out.println(System.getProperty("${ComSpec}"));
//        System.setProperty("name","scm");
//        System.out.println(System.getProperty("name"));
//        Son son = new Son();
//        son.run();
//        Son son1 = new Son();
//        son1.run();
//        ClassLoader classLoader = BookService.class.getClassLoader();
//        System.out.println(classLoader);
        List<Integer> list = test.getList();
        for (int i:list
             ) {
            System.out.println(i);

        }

    }
    @Test
    void aoptest(){
//        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(Mpconf.class);
//        AopServiceimpl bean = applicationContext.getBean(AopServiceimpl.class);
        Boolean pass = service.pass("sssss", "scm521 ");
        // /u0x0d 啊哈哈
        System.out.println(pass);
    }
    @Test
    void zhaungzhang() throws IOException {
        service.zhuanzhang("scm","huangju",100);
    }
    @Test
    void Scheduledtest(){
//        Timer timer=new Timer();
//        TimerTask task=new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("timer is running");
//            }
//        };
//        timer.schedule(task,0,2000);
        new Thread(()-> System.out.println("runable is running")).start();
//        @FunctionalInterface//单方法接口注解表示
        Book book=new Book();
        book.setName("asdad");
        Book book1=new Book();
        book1.setName("agdgd");
        Book book2=new Book();
        book2.setName("wfgergf");
        Book book3=new Book();
        book3.setName("gfdee");
        List<Book> list=new ArrayList<Book>();
        list.add(book);
        list.add(book1);
        list.add(book2);
        list.add(book3);
        list.sort((Book b,Book b1)->b1.getName().compareTo(b.getName()) );
        for (Book books:list
             ) {
            System.out.println(books);
            //b.getName().compareTo(b1.getName()
//            Book{id=0, name='agdgd', maker='null'}
//            Book{id=0, name='asdad', maker='null'}
//            Book{id=0, name='gfdee', maker='null'}
//            Book{id=0, name='wfgergf', maker='null'}
//            (Book b,Book b1)->b1.getName().compareTo(b.getName())
//            Book{id=0, name='wfgergf', maker='null'}
//            Book{id=0, name='gfdee', maker='null'}
//            Book{id=0, name='asdad', maker='null'}
//            Book{id=0, name='agdgd', maker='null'}
        }
    }

    @Test
    void mailtest() throws MessagingException {
//        sendMail.sendmessage();
//        String[] arr=new String[]{"aaa","bbb"};
//        List<String> strings = Arrays.asList(arr);
//        System.out.println( strings.get(0));

        Object proxy = Proxy.newProxyInstance(newcall.class.getClassLoader(), newcall.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                args[0]=2;
                System.out.println("this is proxy");
                Object invoke = method.invoke(new newcall(),args);
                return invoke;
            }
        });
        Callbock callbock = (Callbock) proxy;
        callbock.success(5);
    }
}
