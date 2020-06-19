package com.sso.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author panqw
 * @date 2020/5/30 16:37
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.sso.goods.dao")
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class);

    }
}
