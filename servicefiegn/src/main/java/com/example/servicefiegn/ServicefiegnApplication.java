package com.example.servicefiegn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 1.feign采用的基于接口的注解
 * 2.feign整合了ribbon,具有负载均衡的能力
 * 3.整合了Hystrix,具有熔断的能力
 *
 * 关于断路由：fiegn自带断路由，默认没有开启，需要手动打开，fiegn.hystrx.enabled = true
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
public class ServicefiegnApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicefiegnApplication.class, args);
	}
}
