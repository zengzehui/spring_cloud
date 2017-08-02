package com.hry.spring.cloud.consumer.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient // 配置本应用将使用服务注册和服务发现
@EnableHystrix // 启用断路器，断路器依赖于服务注册和发现。
public class SimpleCloudConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleCloudConsumerApplication.class, args);
	}
	
	@LoadBalanced // 必须加上引注解，否则不会去注册中心将  "http://cloud-simple-service/simple" 里的cloud-simple-service转化为真实的ip和端口
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}