package com.atguigu.cloud.controller;

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxz
 * @date 15:25 2024/3/4
 */
@RestController
public class StorageController
{
    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     *
     * @param productId productId
     * @param count     count
     * @return com.atguigu.cloud.resp.ResultData
     * @author wxz
     * @date 15:25 2024/3/4
     */
    @RequestMapping("/storage/decrease")
    public ResultData decrease(Long productId, Integer count)
    {

        storageService.decrease(productId, count);
        return ResultData.success("扣减库存成功!");
    }
}
