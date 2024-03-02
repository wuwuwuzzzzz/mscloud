package com.atguigu.cloud.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

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

    /**
     * @param request request
     * @return com.atguigu.cloud.resp.ResultData<java.lang.String>
     * @author wxz
     * @date 12:28 2024/3/2
     */
    @GetMapping(value = "/pay/gateway/filter")
    public ResultData<String> getGatewayFilter(HttpServletRequest request)
    {
        String result = "";
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements())
        {
            String headName = headers.nextElement();
            String headValue = request.getHeader(headName);
            System.out.println("请求头名: " + headName + "\t\t\t" + "请求头值: " + headValue);
            if ("X-Request-atguigu1".equalsIgnoreCase(headName) || "X-Request-atguigu2".equalsIgnoreCase(headName))
            {
                result = result + headName + "\t " + headValue + " ";
            }
        }
        return ResultData.success("getGatewayFilter 过滤器 test： " + result + " \t " + DateUtil.now());
    }
}