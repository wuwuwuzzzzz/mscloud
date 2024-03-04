package com.atguigu.cloud.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * @author wxz
 * @date 10:17 2024/3/4
 */
@Component
public class MyRequestOriginParser implements RequestOriginParser
{
    /**
     * @param httpServletRequest httpServletRequest
     * @return java.lang.String
     * @author wxz
     * @date 10:17 2024/3/4
     */
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest)
    {
        return httpServletRequest.getParameter("serverName");
    }
}
