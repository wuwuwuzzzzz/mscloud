package com.atguigu.cloud.mapper;

import com.atguigu.cloud.entities.Storage;
import tk.mybatis.mapper.common.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wxz
 * @date 15:20 2024/3/4
 */
public interface StorageMapper extends Mapper<Storage>
{
    /**
     * @param productId productId
     * @param count     count
     * @author wxz
     * @date 15:23 2024/3/4
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}