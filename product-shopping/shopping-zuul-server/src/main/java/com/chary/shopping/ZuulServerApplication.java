package com.chary.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy			//启用zuul代理
public class ZuulServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApplication.class, args);
	}
}
