package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxz
 * @date 17:00 2024/3/1
 */
@RestController
public class OrderGetWayController
{
    @Resource
    private PayFeignApi payFeignApi;

    /**
     * @param id id
     * @return com.atguigu.cloud.resp.ResultData
     * @author wxz
     * @date 17:03 2024/3/1
     */
    @GetMapping("/feign/pay/gateway/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id)
    {
        return payFeignApi.getById(id);
    }

    /**
     * @return com.atguigu.cloud.resp.ResultData<java.lang.String>
     * @author wxz
     * @date 17:03 2024/3/1
     */
    @GetMapping("/feign/pay/gateway/info")
    public ResultData<String> getGatewayIno()
    {
        return payFeignApi.getGatewayInfo();
    }
}
