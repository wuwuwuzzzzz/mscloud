package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author wxz
 * @date 11:23 2024/2/28
 */
@SpringBootApplication
@MapperScan("com.atguigu.cloud.mapper")
public class Main8001
{
    public static void main(String[] args)
    {
        SpringApplication.run(Main8001.class, args);
    }
}