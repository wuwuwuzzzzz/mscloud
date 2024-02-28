package com.atguigu.cloud.resp;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wxz
 * @date 14:23 2024/2/28
 */
@Data
@Accessors(chain = true)
public class ResultData<T>
{
    /**
     * 状态码
     */
    private String code;

    /**
     * 描述信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 时间戳
     */
    private long timestamp;

    public ResultData()
    {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data)
    {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResultData<T> fail(String code, String message)
    {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMessage(message);

        return resultData;
    }
}
