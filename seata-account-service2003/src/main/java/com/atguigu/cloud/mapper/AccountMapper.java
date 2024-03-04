package com.atguigu.cloud.mapper;

import com.atguigu.cloud.entities.Account;
import tk.mybatis.mapper.common.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wxz
 * @date 15:20 2024/3/4
 */
public interface AccountMapper extends Mapper<Account>
{
    /**
     * @param userId userId
     * @param money  money
     * @author wxz
     * @date 15:39 2024/3/4
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}