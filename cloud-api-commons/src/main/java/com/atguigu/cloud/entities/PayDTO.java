package com.atguigu.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author wxz
 * @date 11:28 2024/2/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayDTO
{
    /**
     * 主键
     */
    private Integer id;

    /**
     * 支付流水号
     */
    private String payNo;

    /**
     * 订单流水号
     */
    private String orderNo;

    /**
     * 用户账号ID
     */
    private Integer userId;

    /**
     * 交易金额
     */
    private BigDecimal amount;
}
