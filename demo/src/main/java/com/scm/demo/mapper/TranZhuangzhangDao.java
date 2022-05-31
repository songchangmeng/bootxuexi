package com.scm.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface TranZhuangzhangDao {
    @Update("update  money set money= money- #{money} where username=#{out}")
    void zhaungzhangout(String out,int money);

    @Update("update  money set money= money+ #{money} where username=#{name}")
    void zhaungzhangin(String name,int money);

//    @Transactional(propagation = Propagation.REQUIRES_NEW)//不加入事务管理
    @Insert("insert into  money(username,money) value(#{name},#{money})")
    void xinzheng(String name,int money);
}
