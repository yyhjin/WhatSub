package com.ssafy.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WhatsubApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhatsubApplication.class, args);
    }

}

