package com.scm.demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scm.demo.Config.Testconf;
import com.scm.demo.Service.BookService;
import com.scm.demo.mapper.BookMapper;
import com.scm.demo.Pojo.Book;
import com.scm.demo.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(properties = {"tests.test=1"},args = {"--tests.test=2"})//临时属性配置和命令行参数
@Import(Testconf.class)//把里面的值加入IOC容器生成bean，被导入的bean无需注解声明为bean，也可以导入配置类，配置类中声明的@Bean也会加进来

class DemoApplicationTests {
    @Autowired
    Testconf testconf;
     @Autowired
    BookMapper book;
     @Autowired
    BookService service;
//     @Autowired
//     String testconfig;
    @Value("${tests.test}")
    String test;
    @Test
    void contextLoads() {

        System.out.println(test);
    //    System.out.println(testconfig);
//        Book thebook= book.selectById(1);
//        System.out.println(thebook);
    }
    @Test

void pagetest(){
        IPage page=new Page(3,5);
        book.selectPage(page,null);
        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
    }
    @Test
  //  @Transactional(rollbackFor = Exception.class)
    void test(){
//        UpdateWrapper<Book> wrapper =new UpdateWrapper();
////        wrapper.eq("name","sssssss").set("maker","pgqdpg");
//        wrapper.likeRight("name","ss").set("maker","jujuninb");
//        book.update(null,wrapper);

        Book book = new Book();
        book.setName("jzmb");
        service.save(book);     //  new NullPointerException();

    }
    //gt > ge >=  lt <  le <=
    @Test
    void importtest(){
        System.out.println(testconf);
    }
}
