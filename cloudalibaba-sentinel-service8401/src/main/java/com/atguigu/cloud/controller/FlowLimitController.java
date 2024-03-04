package com.atguigu.cloud.controller;

import com.atguigu.cloud.service.FlowLimitService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author wxz
 * @date 17:07 2024/3/3
 */
@Slf4j
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

    /**
     * @return java.lang.String
     * @author wxz
     * @date 18:06 2024/3/3
     */
    @GetMapping("/testE")
    public String testE()
    {
        System.out.println(System.currentTimeMillis() + "      testE,排队等待");
        return "------testE";
    }

    /**
     * 新增熔断规则-慢调用比例
     *
     * @return java.lang.String
     * @author wxz
     * @date 09:32 2024/3/4
     */
    @GetMapping("/testF")
    public String testF()
    {
        //暂停几秒钟线程
        try
        {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage());
        }
        System.out.println("----测试:新增熔断规则-慢调用比例 ");
        return "------testF 新增熔断规则-慢调用比例";
    }

    /**
     * 新增熔断规则-异常比例
     *
     * @return java.lang.String
     * @author wxz
     * @date 09:32 2024/3/4
     */
    @GetMapping("/testG")
    public String testG()
    {
        System.out.println("----测试:新增熔断规则-异常比例 ");
        int age = 10 / 0;
        return "------testG,新增熔断规则-异常比例 ";
    }

    /**
     * 新增熔断规则-异常数
     *
     * @return java.lang.String
     * @author wxz
     * @date 09:26 2024/3/4
     */
    @GetMapping("/testH")
    public String testH()
    {
        System.out.println("----测试:新增熔断规则-异常数 ");
        int age = 10 / 0;
        return "------testH,新增熔断规则-异常数 ";
    }
}
