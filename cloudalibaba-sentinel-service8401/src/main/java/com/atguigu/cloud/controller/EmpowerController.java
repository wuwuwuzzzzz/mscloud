package com.atguigu.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxz
 * @date 10:16 2024/3/4
 */
@RestController
@Slf4j
public class EmpowerController
{
    /**
     * @return java.lang.String
     * @author wxz
     * @date 10:16 2024/3/4
     */
    @GetMapping(value = "/empower")
    public String requestSentinel4()
    {
        log.info("测试Sentinel授权规则empower");
        return "Sentinel授权规则";
    }
}
