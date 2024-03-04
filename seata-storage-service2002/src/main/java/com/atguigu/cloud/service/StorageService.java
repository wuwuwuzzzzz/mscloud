package com.atguigu.cloud.service;

/**
 * @author wxz
 * @date 15:22 2024/3/4
 */
public interface StorageService
{
    /**
     * 扣减库存
     *
     * @param productId productId
     * @param count     count
     * @author wxz
     * @date 15:21 2024/3/4
     */
    void decrease(Long productId, Integer count);
}
