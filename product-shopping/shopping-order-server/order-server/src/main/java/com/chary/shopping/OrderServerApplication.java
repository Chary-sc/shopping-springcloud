package com.chary.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Hello world!
 *


@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker	//开启熔断降级
 */
@EnableRedisHttpSession	//将session存入redis
@SpringCloudApplication	//上面的三合一
//@MapperScan("com.chary.shopping.mapper")	//mybatis映射文件对应的接口的包路径
@ServletComponentScan	
@EnableHystrixDashboard	//启动仪表盘    访问http://localhost:7777/actuator/hystrix.stream
//@EnableFeignClients(basePackages = {"com.chary.shopping"})	//feign接口的包路径
//@EnableFeignClients(basePackages = {"com.chary.snacknet.user","com.chary.snacknet.product"})	//feign接口的包路径

public class OrderServerApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderServerApplication.class, args);
    }
}
