package com.atguigu.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxz
 * @date 13:05 2024/3/3
 */
@RestController
public class PayAlibabaController
{
    @Value("${server.port}")
    private String serverPort;

    /**
     * @param id id
     * @return java.lang.String
     * @author wxz
     * @date 13:05 2024/3/3
     */
    @GetMapping("/pay/nacos/{id}")
    public String getPayInfo(@PathVariable("id") Integer id)
    {
        return "nacos registry, serverPort: " + serverPort + "\t id" + id;
    }
}