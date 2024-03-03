package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wxz
 * @date 13:04 2024/3/3
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main9002
{
    public static void main(String[] args)
    {
        SpringApplication.run(Main9002.class, args);
    }
}