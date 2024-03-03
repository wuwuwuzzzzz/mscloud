package com.atguigu.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author wxz
 * @date 17:51 2024/3/3
 */
@Service
public class FlowLimitService
{
    /**
     * @author wxz
     * @date 17:52 2024/3/3
     */
    @SentinelResource(value = "common")
    public void common()
    {
        System.out.println("------FlowLimitService come in");
    }
}
