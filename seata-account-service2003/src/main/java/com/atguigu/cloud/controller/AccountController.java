package com.atguigu.cloud.controller;

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxz
 * @date 15:43 2024/3/4
 */
@RestController
public class AccountController
{
    @Resource
    AccountService accountService;

    /**
     * 扣减账户余额
     *
     * @param userId userId
     * @param money  money
     * @return com.atguigu.cloud.resp.ResultData
     * @author wxz
     * @date 15:44 2024/3/4
     */
    @RequestMapping("/account/decrease")
    public ResultData decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money)
    {
        accountService.decrease(userId, money);
        return ResultData.success("扣减账户余额成功！");
    }
}
