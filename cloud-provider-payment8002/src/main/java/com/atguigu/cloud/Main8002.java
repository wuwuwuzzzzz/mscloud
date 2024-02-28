package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author wxz
 * @date 11:23 2024/2/28
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@MapperScan("com.atguigu.cloud.mapper")
public class Main8002
{
    public static void main(String[] args)
    {
        SpringApplication.run(Main8002.class, args);
    }
}