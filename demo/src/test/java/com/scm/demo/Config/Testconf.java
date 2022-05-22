package com.scm.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Testconf {
    @Bean
    public String test(){
        return "test bean config";
    }
}
