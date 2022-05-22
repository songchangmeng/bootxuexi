package com.scm.demo.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scm.demo.Pojo.Book;
import com.scm.demo.Service.BookService;
import com.scm.demo.mapper.BookMapper;
import org.springframework.stereotype.Service;

@Service
public class BookServiceimpl extends ServiceImpl<BookMapper, Book> implements BookService {
}
