package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Order;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxz
 * @date 15:14 2024/3/4
 */
@RestController
public class OrderController
{
    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param order order
     * @return com.atguigu.cloud.resp.ResultData
     * @author wxz
     * @date 15:14 2024/3/4
     */
    @GetMapping("/order/create")
    public ResultData create(Order order)
    {
        orderService.create(order);
        return ResultData.success(order);
    }
}
