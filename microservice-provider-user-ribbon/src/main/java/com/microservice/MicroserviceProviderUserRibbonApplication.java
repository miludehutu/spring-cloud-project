package com.microservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@MapperScan("com.microservice.mapper") //扫描的mapper测试
@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceProviderUserRibbonApplication {

@Bean
@LoadBalanced
 public RestTemplate restTemplate(){
        return  new RestTemplate();
}

public static void main(String[] args) {
        SpringApplication.run(MicroserviceProviderUserRibbonApplication.class, args);
        }

        }
