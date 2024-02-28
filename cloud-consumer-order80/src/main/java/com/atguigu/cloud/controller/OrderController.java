package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wxz
 * @date 14:46 2024/2/28
 */
@RestController
public class OrderController
{
    public static final String PAYMENT_SRV_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @param payDTO payDTO
     * @return ResultData
     * @author wxz
     * @date 14:47 2024/2/28
     */
    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO)
    {
        return restTemplate.postForObject(PAYMENT_SRV_URL + "/pay/add", payDTO, ResultData.class);
    }

    /**
     * @param id id
     * @return com.atguigu.cloud.resp.ResultData
     * @author wxz
     * @date 14:48 2024/2/28
     */
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id)
    {
        return restTemplate.getForObject(PAYMENT_SRV_URL + "/pay/get/" + id, ResultData.class, id);
    }
}