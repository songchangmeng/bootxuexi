package com.scm.demo.Controller;

import com.scm.demo.Pojo.Book;
import com.scm.demo.Service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@Slf4j
@RestController
@RequestMapping("books")
public class bookController {
//   private static final Logger log= LoggerFactory.getLogger(bookController.class);
    @Resource
   public Book book;
    @Autowired
    BookService bookService;
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
}
