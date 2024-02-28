package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.mapper.PayMapper;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wxz
 * @date 11:32 2024/2/28
 */
@Service
public class PayServiceImpl implements PayService
{
    @Resource
    PayMapper payMapper;

    /**
     * @param pay pay
     * @return int
     * @author wxz
     * @date 11:30 2024/2/28
     */
    @Override
    public int add(Pay pay)
    {
        return payMapper.insertSelective(pay);
    }

    /**
     * @param id id
     * @return int
     * @author wxz
     * @date 11:34 2024/2/28
     */
    @Override
    public int delete(Integer id)
    {
        return payMapper.deleteByExample(id);
    }

    /**
     * @param pay pay
     * @return int
     * @author wxz
     * @date 11:34 2024/2/28
     */
    @Override
    public int update(Pay pay)
    {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    /**
     * @param id id
     * @return com.atguigu.cloud.entities.Pay
     * @author wxz
     * @date 11:34 2024/2/28
     */
    @Override
    public Pay getById(Integer id)
    {
        return payMapper.selectByPrimaryKey(id);
    }

    /**
     * @return java.util.List<com.atguigu.cloud.entities.Pay>
     * @author wxz
     * @date 11:35 2024/2/28
     */
    @Override
    public List<Pay> getAll()
    {
        return payMapper.selectAll();
    }
}
