package com.scm.demo.Service.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduldtest {
    @Scheduled(cron ="0/1 * * * * ?" )
    public void scheduled(){
        System.out.println("Scheduled is run ");
    }
}
