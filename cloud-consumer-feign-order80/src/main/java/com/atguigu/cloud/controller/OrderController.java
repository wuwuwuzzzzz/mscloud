package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author wxz
 * @date 14:46 2024/2/28
 */
@RestController
public class OrderController
{
    @Resource
    private PayFeignApi payFeignApi;

    /**
     * 新增一条支付相关流水记录
     *
     * @param payDTO payDTO
     * @return com.atguigu.cloud.resp.ResultData
     * @author wxz
     * @date 10:03 2024/2/29
     */
    @PostMapping("/feign/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO)
    {
        System.out.println("第一步：模拟本地addOrder新增订单成功(省略sql操作)，第二步：再开启addPay支付微服务远程调用");
        return payFeignApi.addPay(payDTO);
    }

    /**
     * 按照主键记录查询支付流水信息
     *
     * @param id id
     * @return com.atguigu.cloud.resp.ResultData
     * @author wxz
     * @date 10:03 2024/2/29
     */
    @GetMapping("/feign/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id)
    {
        System.out.println("-------支付微服务远程调用，按照id查询订单支付流水信息");
        return payFeignApi.getPayInfo(id);
    }

    /**
     * openfeign天然支持负载均衡演示
     *
     * @return java.lang.String
     * @author wxz
     * @date 10:03 2024/2/29
     */
    @GetMapping("/feign/pay/mylb")
    public String mylb()
    {
        return payFeignApi.mylb();
    }
}