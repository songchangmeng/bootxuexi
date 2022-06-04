package com.scm.demo.Pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.validation.annotation.Validated;


import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component//加载到spring容器
@Data
@ConfigurationProperties(prefix = "test")//属性匹配配置文件忽略大小写和 _ - setter方法注入
//@Value({${xxx}})不支持宽松绑定
@Validated//对bean开启校验，校验不符合条件报错
public class Test {
     private  String name;
     private String maker;
     @DurationUnit(ChronoUnit.HOURS)
     private Duration timeout;
     private DataSize dataSize;
 //    @Max(value = 5,message = "最大值为5")//校验格式
     private int port;
     private List<Integer> list;
}
