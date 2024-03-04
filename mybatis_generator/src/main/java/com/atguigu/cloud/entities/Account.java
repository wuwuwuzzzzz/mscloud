package com.atguigu.cloud.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 表名：t_account
 *
 * @author wxz
 * @date 15:17 2024/3/4
 */
@Data
@Table(name = "t_account")
public class Account
{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 总额度
     */
    private Long total;

    /**
     * 已用额度
     */
    private Long used;

    /**
     * 剩余可用额度
     */
    private Long residue;
}