package com.atguigu.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxz
 * @date 09:43 2024/3/4
 */
@RestController
@Slf4j
public class RateLimitController
{
    /**
     * @return java.lang.String
     * @author wxz
     * @date 09:43 2024/3/4
     */
    @GetMapping("/rateLimit/byUrl")
    public String byUrl()
    {
        return "按rest地址限流测试OK";
    }

    /**
     * @return java.lang.String
     * @author wxz
     * @date 09:46 2024/3/4
     */
    @GetMapping("/rateLimit/byResource")
    @SentinelResource(value = "byResourceSentinelResource", blockHandler = "handleException")
    public String byResource()
    {
        return "按资源名称SentinelResource限流测试OK";
    }

    /**
     * @param exception exception
     * @return java.lang.String
     * @author wxz
     * @date 09:47 2024/3/4
     */
    public String handleException(BlockException exception)
    {
        return "服务不可用@SentinelResource启动" + "\t" + "o(╥﹏╥)o";
    }

    /**
     * @param p1 p1
     * @return java.lang.String
     * @author wxz
     * @date 09:52 2024/3/4
     */
    @GetMapping("/rateLimit/doAction/{p1}")
    @SentinelResource(value = "doActionSentinelResource", blockHandler = "doActionBlockHandler", fallback = "doActionFallback")
    public String doAction(@PathVariable("p1") Integer p1)
    {
        if (p1 == 0)
        {
            throw new RuntimeException("p1等于零直接异常");
        }
        return "doAction";
    }

    /**
     * @param p1 p1
     * @param e  e
     * @return java.lang.String
     * @author wxz
     * @date 09:52 2024/3/4
     */
    public String doActionBlockHandler(@PathVariable("p1") Integer p1, BlockException e)
    {
        log.error("sentinel配置自定义限流了:{}", e.getMessage());
        return "sentinel配置自定义限流了";
    }

    /**
     * @param p1 p1
     * @param e  e
     * @return java.lang.String
     * @author wxz
     * @date 09:52 2024/3/4
     */
    public String doActionFallback(@PathVariable("p1") Integer p1, Throwable e)
    {
        log.error("程序逻辑异常了:{}", e.getMessage());
        return "程序逻辑异常了" + "\t" + e.getMessage();
    }
}
