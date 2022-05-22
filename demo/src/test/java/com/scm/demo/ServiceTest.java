package com.scm.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.scm.demo.Pojo.Book;
import com.scm.demo.Service.BookService;
import com.scm.demo.Service.impl.BookServiceimpl;
import com.scm.demo.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.boot.test.json.JsonbTester;

import java.util.Map;

@SpringBootTest
public class ServiceTest {
    @Autowired
    BookServiceimpl bookService;
    @Autowired
    BookMapper bookMapper;
    @Test
    void ins(){
        Book book = new Book();
        book.setName("pgqq");
        book.setMaker("scm");
        bookService.save(book);
//        System.out.println(bookService.getById(1));
//        bookService.removeById(3);
        Book bos=new Book();
        bos.setId(15);
        bos.setName("scm");
//        UpdateWrapper<Book> updataWrapper=new UpdateWrapper<Book>();
//        updataWrapper.eq("id",9).set(bos.getMaker()==null,"maker",null);
      //  bookService.update(bos,null);
        bookMapper.updateById(bos);
    }

    @Test
    void test() {
        Book book = new Book();
        book.setName("pgqq");
        book.setMaker("scm");
        String s = JSON.toJSONString(book);
        System.out.println(s);

    }
}
