package com.atguigu.cloud.mygateway;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wxz
 * @date 22:25 2024/3/2
 */
@Component
public class MyGatewayFilterFactory extends AbstractGatewayFilterFactory<MyGatewayFilterFactory.Config>
{
    public MyGatewayFilterFactory()
    {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config)
    {
        return (exchange, chain) ->
        {
            ServerHttpRequest request = exchange.getRequest();
            System.out.println("进入了自定义网关过滤器MyGatewayFilterFactory，status：" + config.getStatus());
            if (request.getQueryParams().containsKey("atguigu"))
            {
                return chain.filter(exchange);
            }
            else
            {
                exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
                return exchange.getResponse().setComplete();
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder()
    {
        return List.of("status");
    }

    @Setter
    @Getter
    public static class Config
    {
        private String status; // 设定一个状态值/标志位，它等于多少，匹配和才可以访问
    }
}