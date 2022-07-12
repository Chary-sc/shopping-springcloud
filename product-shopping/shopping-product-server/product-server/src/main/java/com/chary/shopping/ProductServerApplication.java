package com.chary.shopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 商品启动类
 * @ClassName: ProductServerApplication
 * @Description:TODO
 * @author Chary
 * @date:  2021年10月22日 上午11:39:00	
 * @param:
 */
@EnableRedisHttpSession	//将session存入redis
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.chary.shopping.mapper")	//mybatis映射文件对应的接口的包路径
@ServletComponentScan	//扫描servlet里面的注解 @Webservlet @WebListener @WebFilter
public class ProductServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServerApplication.class, args);
	}

}