package com.chary.shopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession	//将session存入redis
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.chary.shopping.mapper")	//mybatis映射文件对应的接口的包路径
@ServletComponentScan	//扫描servlet里面的注解 @Webservlet @WebListener @WebFilter
@EnableFeignClients(basePackages = {"com.chary.shopping"})	//feign接口的包路径
public class UserServerApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(UserServerApplication.class, args);
    }
}
