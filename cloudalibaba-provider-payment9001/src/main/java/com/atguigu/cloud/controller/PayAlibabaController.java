package com.atguigu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author wxz
 * @date 13:05 2024/3/3
 */
@RestController
public class PayAlibabaController
{
    @Value("${server.port}")
    private String serverPort;

    /**
     * @param id id
     * @return java.lang.String
     * @author wxz
     * @date 13:05 2024/3/3
     */
    @GetMapping("/pay/nacos/{id}")
    public String getPayInfo(@PathVariable("id") Integer id)
    {
        return "nacos registry, serverPort: " + serverPort + "\t id" + id;
    }

    /**
     * @param orderNo orderNo
     * @return com.atguigu.cloud.resp.ResultData
     * @author wxz
     * @date 11:37 2024/3/4
     */
    @GetMapping("/pay/nacos/get/{orderNo}")
    @SentinelResource(value = "getPayByOrderNo", blockHandler = "handlerBlockHandler")
    public ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo)
    {
        //模拟从数据库查询出数据并赋值给DTO
        PayDTO payDTO = new PayDTO();

        payDTO.setId(1024);
        payDTO.setOrderNo(orderNo);
        payDTO.setAmount(BigDecimal.valueOf(9.9));
        payDTO.setPayNo("pay:" + IdUtil.fastUUID());
        payDTO.setUserId(1);

        return ResultData.success("查询返回值：" + payDTO);
    }

    /**
     * @param orderNo   orderNo
     * @param exception exception
     * @return com.atguigu.cloud.resp.ResultData
     * @author wxz
     * @date 11:37 2024/3/4
     */
    public ResultData handlerBlockHandler(@PathVariable("orderNo") String orderNo, BlockException exception)
    {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "getPayByOrderNo服务不可用，" +
                "触发sentinel流控配置规则" + "\t" + "o(╥﹏╥)o");
    }
}