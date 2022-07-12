package com.chary.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableDiscoveryClient		//可以注册到（除Eureka）其它注册中心
@EnableConfigServer			//配置服务器
public class ConfigServerApplication {
    public static void main( String[] args ){
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
