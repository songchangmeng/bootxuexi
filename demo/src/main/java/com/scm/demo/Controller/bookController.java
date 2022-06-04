package com.scm.demo.Controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.scm.demo.Pojo.Book;
import com.scm.demo.Service.BookService;
import com.scm.demo.Service.impl.BookServiceimpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("books")
public class bookController {
//   private static final Logger log= LoggerFactory.getLogger(bookController.class);
   @Resource
   public Book book;
    @Autowired
    BookServiceimpl bookService;
    @Value("${test.name}")
    public String name;

@PostMapping("/getid")
    public String getid(String Id){
    System.out.println("hahaha"+Id+1+2+3);
    log.error("error："+Id);
    log.debug("debug："+Id);
    System.out.println(book);
    System.out.println(name);
    return Id;
}
@PutMapping
    public boolean update(@RequestBody Book book){
   // return bookService.update(book,new UpdateWrapper<Book>().eq("id",book.getId()));
    return bookService.updateById(book);
}
@GetMapping("getid")
@Cacheable(value = "cachespace",key = "#id")
    public Book getBookbyId(int id){
    return bookService.getBookById(id);
}
    @GetMapping("getlist")

    public List<Book> getBookbyId(@RequestBody List<Integer> id){

        List<Book> books = bookService.listByIds(id);//查询为空返回的list长度为0，但是不为null。为null说明查询失败
        if (books==null){
            System.out.println("books is null");
        }
        return books;
    }
    @PutMapping("update")
    public Boolean update(@RequestBody List<Integer> ids ) throws IOException {
//    Book book =new Book();
//    book.setId(id);
//    book.setName("updated");
      if (true) throw new IOException();
        UpdateWrapper<Book> bookUpdateWrapper = new UpdateWrapper<>();
        bookUpdateWrapper.in("id",ids).set("maker","dacaojzmb");
        return bookService.update(bookUpdateWrapper);//增删改操作返回值为改的行数，修改0行为false，大于0行为true
    }
}
