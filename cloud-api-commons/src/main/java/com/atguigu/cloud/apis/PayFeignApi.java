package com.atguigu.cloud.apis;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wxz
 * @date 09:51 2024/2/29
 */
//@FeignClient("cloud-payment-service")
@FeignClient("cloud-gateway")
public interface PayFeignApi
{
    /**
     * 新增一条支付相关流水记录
     *
     * @param payDTO payDTO
     * @return com.atguigu.cloud.resp.ResultData
     * @author wxz
     * @date 09:55 2024/2/29
     */
    @PostMapping("/pay/add")
    ResultData addPay(@RequestBody PayDTO payDTO);

    /**
     * 按照主键记录查询支付流水信息
     *
     * @param id id
     * @return com.atguigu.cloud.resp.ResultData
     * @author wxz
     * @date 09:55 2024/2/29
     */
    @GetMapping("/pay/get/{id}")
    ResultData getPayInfo(@PathVariable("id") Integer id);

    /**
     * openfeign天然支持负载均衡演示
     *
     * @return java.lang.String
     * @author wxz
     * @date 09:55 2024/2/29
     */
    @GetMapping("/pay/get/info")
    String mylb();

    /**
     * Resilience4j CircuitBreaker 的例子
     *
     * @param id id
     * @return java.lang.String
     * @author wxz
     * @date 15:38 2024/2/29
     */
    @GetMapping("/pay/circuit/{id}")
    String myCircuit(@PathVariable("id") Integer id);

    /**
     * Resilience4j Bulkhead 的例子
     *
     * @param id id
     * @return java.lang.String
     * @author wxz
     * @date 16:51 2024/2/29
     */
    @GetMapping("/pay/bulkhead/{id}")
    String myBulkhead(@PathVariable("id") Integer id);

    /**
     * Resilience4j Ratelimit 的例子
     *
     * @param id
     * @return java.lang.String
     * @author wxz
     * @date 09:52 2024/3/1
     */
    @GetMapping("/pay/ratelimit/{id}")
    String myRatelimit(@PathVariable("id") Integer id);

    /**
     * Micrometer(Sleuth)进行链路监控的例子
     *
     * @param id id
     * @return java.lang.String
     * @author wxz
     * @date 11:57 2024/3/1
     */
    @GetMapping("/pay/micrometer/{id}")
    String myMicrometer(@PathVariable("id") Integer id);

    /**
     * GateWay进行网关测试案例01
     *
     * @param id
     * @return com.atguigu.cloud.resp.ResultData
     * @author wxz
     * @date 16:57 2024/3/1
     */
    @GetMapping("/pay/gateway/get/{id}")
    ResultData getById(@PathVariable("id") Integer id);

    /**
     * GateWay进行网关测试案例02
     *
     * @return com.atguigu.cloud.resp.ResultData<java.lang.String>
     * @author wxz
     * @date 16:58 2024/3/1
     */
    @GetMapping("/pay/gateway/info")
    ResultData<String> getGatewayInfo();
}
