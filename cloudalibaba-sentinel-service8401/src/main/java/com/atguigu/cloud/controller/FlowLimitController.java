package com.atguigu.cloud.controller;

import com.atguigu.cloud.service.FlowLimitService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxz
 * @date 17:07 2024/3/3
 */
@RestController
public class FlowLimitController
{
    @Resource
    private FlowLimitService flowLimitService;

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

    /**
     * C和D两个请求都访问flowLimitService.common()方法，阈值到达后对C限流，对D不管
     *
     * @return java.lang.String
     * @author wxz
     * @date 17:54 2024/3/3
     */
    @GetMapping("/testC")
    public String testC()
    {
        flowLimitService.common();
        return "------testC";
    }

    /**
     * @return java.lang.String
     * @author wxz
     * @date 17:54 2024/3/3
     */
    @GetMapping("/testD")
    public String testD()
    {
        flowLimitService.common();
        return "------testD";
    }
}
