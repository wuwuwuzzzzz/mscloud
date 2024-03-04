package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wxz
 * @date 15:00 2024/3/4
 */
@FeignClient("seata-storage-service")
public interface StorageFeignApi
{
    /**
     * 扣减库存
     *
     * @param productId productId
     * @param count     count
     * @return com.atguigu.cloud.resp.ResultData
     * @author wxz
     * @date 15:01 2024/3/4
     */
    @PostMapping("/storage/decrease")
    ResultData decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
