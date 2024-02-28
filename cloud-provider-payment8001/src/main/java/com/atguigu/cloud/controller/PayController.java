package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wxz
 * @date 11:36 2024/2/28
 */
@Slf4j
@Controller
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
    public int addPay(@RequestBody Pay pay)
    {
        System.out.println(pay.toString());
        return payService.add(pay);
    }

    /**
     * @param id id
     * @return java.lang.Integer
     * @author wxz
     * @date 11:38 2024/2/28
     */
    @DeleteMapping(value = "/pay/del/{id}")
    public Integer deletePay(@PathVariable("id") Integer id)
    {
        return payService.delete(id);
    }

    /**
     * @param payDTO payDTO
     * @return java.lang.String
     * @author wxz
     * @date 11:38 2024/2/28
     */
    @PutMapping(value = "/pay/update")
    public int updatePay(@RequestBody PayDTO payDTO)
    {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        return payService.update(pay);
    }

    /**
     * @param id id
     * @return com.atguigu.cloud.entities.Pay
     * @author wxz
     * @date 11:38 2024/2/28
     */
    @GetMapping(value = "/pay/get/{id}")
    public Pay getById(@PathVariable("id") Integer id)
    {
        return payService.getById(id);
    }

    /**
     * @return java.util.List<com.atguigu.cloud.entities.Pay>
     * @author wxz
     * @date 11:39 2024/2/28
     */
    @GetMapping("/pay/getAll")
    public List<Pay> getAll()
    {
        return payService.getAll();
    }
}
