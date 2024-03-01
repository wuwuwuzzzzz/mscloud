package com.atguigu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxz
 * @date 16:47 2024/3/1
 */
@RestController
public class PayGateWayController
{
    @Resource
    PayService payService;

    /**
     * @param id id
     * @return com.atguigu.cloud.resp.ResultData<com.atguigu.cloud.entities.Pay>
     * @author wxz
     * @date 16:47 2024/3/1
     */
    @GetMapping("/pay/gateway/get/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id)
    {
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    /**
     * @return com.atguigu.cloud.resp.ResultData<java.lang.String>
     * @author wxz
     * @date 16:47 2024/3/1
     */
    @GetMapping("/pay/gateway/info")
    public ResultData<String> getGatewayInfo()
    {
        return ResultData.success("gateway info test：" + IdUtil.simpleUUID());
    }
}