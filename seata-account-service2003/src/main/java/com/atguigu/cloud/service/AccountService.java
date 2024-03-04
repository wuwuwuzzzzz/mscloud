package com.atguigu.cloud.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author wxz
 * @date 15:41 2024/3/4
 */
public interface AccountService
{
    /**
     * 扣减账户余额
     *
     * @param userId userId
     * @param money  money
     * @author wxz
     * @date 15:41 2024/3/4
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}
