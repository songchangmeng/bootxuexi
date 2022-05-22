package com.scm.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//随机端口
@AutoConfigureMockMvc//开启虚拟MVC调用
public class WebTest {
    @Test
    public void test(@Autowired MockMvc mvc) throws Exception {
        //创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/books/getid");
        //发送请求
        builder.param("Id","6");
        mvc.perform(builder);
    }
    @Test
    public void teststute(@Autowired MockMvc mvc) throws Exception {
        //创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/books/getid");
        //发送请求
        ResultActions resultActions=mvc.perform(builder);
        StatusResultMatchers matcher= MockMvcResultMatchers.status();
        //设置预期值状态码200
        ResultMatcher ok = matcher.isOk();
        //添加预期值进行匹配
        resultActions.andExpect(ok);
    }
    @Test
    public void testBody(@Autowired MockMvc mvc) throws Exception {
        //创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/books/getid");
        //发送请求
        ResultActions resultActions=mvc.perform(builder);
        ContentResultMatchers matcher= MockMvcResultMatchers.content();
        //设置预期值返回字符串ssss
        ResultMatcher ok = matcher.string("sssss");
        //添加预期值进行匹配
        resultActions.andExpect(ok);
    }
}
