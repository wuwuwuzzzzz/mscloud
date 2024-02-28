package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;

import java.util.List;

/**
 * @author wxz
 * @date 11:29 2024/2/28
 */
public interface PayService
{
    /**
     * add
     *
     * @param pay pay
     * @return int
     * @author wxz
     * @date 11:30 2024/2/28
     */
    int add(Pay pay);

    /**
     * delete
     *
     * @param id id
     * @return int
     * @author wxz
     * @date 11:31 2024/2/28
     */
    int delete(Integer id);

    /**
     * update
     *
     * @param pay pay
     * @return int
     * @author wxz
     * @date 11:31 2024/2/28
     */
    int update(Pay pay);

    /**
     * getById
     *
     * @param id id
     * @return com.atguigu.cloud.entities.Pay
     * @author wxz
     * @date 11:31 2024/2/28
     */
    Pay getById(Integer id);

    /**
     * getAll
     *
     * @return java.util.List<com.atguigu.cloud.entities.Pay>
     * @author wxz
     * @date 11:31 2024/2/28
     */
    List<Pay> getAll();
}
