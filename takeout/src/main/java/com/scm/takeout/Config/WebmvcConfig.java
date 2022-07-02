package com.scm.takeout.Config;

import com.scm.takeout.utils.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;
@Slf4j
@Configuration
@EnableTransactionManagement
//WebMvcAutoConfiguration当没有WebMvcConfigurationSupport这个类的bean时才自动装配，
// 当有这个bean后WebMvcAutoConfiguration不会自动装配，所以static下静态访问无效。WebMvcConfigurationSupport会把默认覆盖
//public class WebmvcConfig extend WebMvcConfigurationSupport { 访问静态无效，改为WebMvcConfigurer接口好使了
public class WebmvcConfig implements WebMvcConfigurer {
    @Autowired
    MyInterceptor myInterceptor;
//    /**
//     * 设置静态资源映射
//     * @param registry
//     */
//     @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        System.out.println("web config");
//        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
//        registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
//    }
//加载拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/employee/login");
    }
//  扩展SpringMvc的消息转换器
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        WebMvcConfigurer.super.extendMessageConverters(converters);
        log.info("自定义消息转化器 被调用!");
        // 创建消息转换器对象
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        // 设置对象转换器，底层使用JackSON 将Java对象 转化为JSON
        messageConverter.setObjectMapper(new JacksonObjectMapper());

        // 将上面的消息转换器对象追加到SpringMVC的 转换器容器 的第一个位置(优先采用下标为 0 位置的消息转换器)
        converters.add(0,messageConverter);


   }
//    @Bean
//    public Docket createRestApi(){
//        //接口文档，文档类型
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.scm.takeout.Controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title("测试高圆圆")
//                .version("1.0").description("高圆圆接口文档").build();
//    }
}
