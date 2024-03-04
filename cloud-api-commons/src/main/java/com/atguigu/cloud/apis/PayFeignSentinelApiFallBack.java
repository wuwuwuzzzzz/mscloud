package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

/**
 * @author wxz
 * @date 11:42 2024/3/4
 */
@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi
{
    /**
     * fallback方法
     *
     * @param orderNo orderNo
     * @return com.atguigu.cloud.resp.ResultData
     * @author wxz
     * @date 11:42 2024/3/4
     */
    @Override
    public ResultData getPayByOrderNo(String orderNo)
    {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}
