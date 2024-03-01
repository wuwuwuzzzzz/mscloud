package com.atguigu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author wxz
 * @date 15:36 2024/2/29
 */
@Slf4j
@RestController
public class PayCircuitController
{
    /**
     * @param id id
     * @return java.lang.String
     * @author wxz
     * @date 15:36 2024/2/29
     */
    @GetMapping("/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id)
    {
        if (id == -4)
        {
            throw new RuntimeException("----circuit id 不能负数");
        }
        if (id == 9999)
        {
            try
            {
                TimeUnit.SECONDS.sleep(5);
            }
            catch (InterruptedException e)
            {
                log.error(e.getMessage());
            }
        }
        return "Hello, circuit! inputId:  " + id + " \t " + IdUtil.simpleUUID();
    }

    /**
     * Resilience4j bulkhead 的例子
     *
     * @param id id
     * @return java.lang.String
     * @author wxz
     * @date 16:51 2024/2/29
     */
    @GetMapping("/pay/bulkhead/{id}")
    public String myBulkhead(@PathVariable("id") Integer id)
    {
        if (id == -4)
        {
            throw new RuntimeException("----bulkhead id 不能-4");
        }

        if (id == 9999)
        {
            try
            {
                TimeUnit.SECONDS.sleep(5);
            }
            catch (InterruptedException e)
            {
                log.error(e.getMessage());
            }
        }

        return "Hello, bulkhead! inputId:  " + id + " \t " + IdUtil.simpleUUID();
    }

    /**
     * Resilience4j ratelimit 的例子
     *
     * @param id id
     * @return java.lang.String
     * @author wxz
     * @date 09:52 2024/3/1
     */
    @GetMapping(value = "/pay/ratelimit/{id}")
    public String myRatelimit(@PathVariable("id") Integer id)
    {
        return "Hello, myRatelimit欢迎到来 inputId:  " + id + " \t " + IdUtil.simpleUUID();
    }
}
