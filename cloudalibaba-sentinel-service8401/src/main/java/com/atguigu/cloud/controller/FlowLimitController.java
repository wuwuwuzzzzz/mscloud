package com.atguigu.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxz
 * @date 17:07 2024/3/3
 */
@RestController
public class FlowLimitController
{
    /**
     * @return java.lang.String
     * @author wxz
     * @date 17:07 2024/3/3
     */
    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    /**
     * @return java.lang.String
     * @author wxz
     * @date 17:07 2024/3/3
     */
    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }
}
