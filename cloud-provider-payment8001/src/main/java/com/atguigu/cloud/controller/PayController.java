package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wxz
 * @date 11:36 2024/2/28
 */
@Slf4j
@RestController
public class PayController
{
    @Resource
    private PayService payService;

    /**
     * @param pay pay
     * @return java.lang.String
     * @author wxz
     * @date 11:38 2024/2/28
     */
    @PostMapping(value = "/pay/add")
    public ResultData<String> addPay(@RequestBody Pay pay)
    {
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("成功添加记录，返回值：" + i);
    }

    /**
     * @param id id
     * @return java.lang.Integer
     * @author wxz
     * @date 11:38 2024/2/28
     */
    @DeleteMapping(value = "/pay/del/{id}")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id)
    {
        return ResultData.success(payService.delete(id));
    }

    /**
     * @param payDTO payDTO
     * @return java.lang.String
     * @author wxz
     * @date 11:38 2024/2/28
     */
    @PutMapping(value = "/pay/update")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO)
    {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return ResultData.success("成功更新记录，返回值：" + i);
    }

    /**
     * @param id id
     * @return com.atguigu.cloud.entities.Pay
     * @author wxz
     * @date 11:38 2024/2/28
     */
    @GetMapping(value = "/pay/get/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id)
    {
        return ResultData.success(payService.getById(id));
    }

    /**
     * @return java.util.List<com.atguigu.cloud.entities.Pay>
     * @author wxz
     * @date 11:39 2024/2/28
     */
    @GetMapping("/pay/getAll")
    public ResultData<List<Pay>> getAll()
    {
        return ResultData.success(payService.getAll());
    }
}
