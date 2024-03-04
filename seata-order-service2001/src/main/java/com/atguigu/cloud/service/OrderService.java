package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Order;

/**
 * @author wxz
 * @date 15:10 2024/3/4
 */
public interface OrderService
{
    /**
     * 创建订单
     *
     * @param order order
     * @author wxz
     * @date 15:10 2024/3/4
     */
    void create(Order order);
}
