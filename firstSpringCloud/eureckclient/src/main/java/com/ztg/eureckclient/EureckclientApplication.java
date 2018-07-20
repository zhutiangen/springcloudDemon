package com.ztg.eureckclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 表示是一个客户端工程
public class EureckclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EureckclientApplication.class, args);
	}
}
