package com.scm.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scm.demo.Pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
//    不使用@Param注解时，参数只能有一个，并且是Javabean。在SQL语句里只能引用JavaBean的属性。
    @Select("select * from book where id = #{id}")
    Book getbook(Book book);
    @Select("select * from book where id = #{book.id}")
    Book getbooks(@Param("book") Book b);
    @Select("select * from book where id = #{i}")
    Book getbooksid(int i);
}
