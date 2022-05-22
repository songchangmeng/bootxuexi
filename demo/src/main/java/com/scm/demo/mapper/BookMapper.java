package com.scm.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scm.demo.Pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper extends BaseMapper<Book> {


}
