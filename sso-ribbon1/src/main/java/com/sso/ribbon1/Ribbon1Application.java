package com.sso.ribbon1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Ribbon1Application {

    public static void main(String[] args) {
        SpringApplication.run(Ribbon1Application.class,args);
    }
}
