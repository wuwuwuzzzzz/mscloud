package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wxz
 * @date 15:00 2024/3/4
 */
@FeignClient("seata-account-service")
public interface AccountFeignApi
{
    /**
     * 扣减账户余额
     *
     * @param userId userId
     * @param money  money
     * @return com.atguigu.cloud.resp.ResultData
     * @author wxz
     * @date 15:01 2024/3/4
     */
    @PostMapping("/account/decrease")
    ResultData decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}
