package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.apis.AccountFeignApi;
import com.atguigu.cloud.apis.StorageFeignApi;
import com.atguigu.cloud.entities.Order;
import com.atguigu.cloud.mapper.OrderMapper;
import com.atguigu.cloud.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * 下订单->减库存->扣余额->改(订单)状态
 *
 * @author wxz
 * @date 15:11 2024/3/4
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService
{
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StorageFeignApi storageFeignApi;

    @Resource
    private AccountFeignApi accountFeignApi;

    @Override
    @GlobalTransactional(name = "wxz-create-order", rollbackFor = Exception.class)
    public void create(Order order)
    {
        // xid检查
        String xid = RootContext.getXID();

        // 1. 新建订单
        log.info("==================>开始新建订单" + "\t" + "xid_order:" + xid);
        // 订单状态status：0：创建中；1：已完结
        order.setStatus(0);
        int result = orderMapper.insertSelective(order);

        if (result > 0)
        {
            // 插入订单成功后获得插入mysql的实体对象
            Order orderFrom = orderMapper.selectOne(order);
            log.info("-------> 新建订单成功，orderFrom info: " + orderFrom);
            System.out.println();
            // 2. 扣减库存
            log.info("-------> 订单微服务开始调用Storage库存，做扣减count");
            storageFeignApi.decrease(orderFrom.getProductId(), orderFrom.getCount());
            log.info("-------> 订单微服务结束调用Storage库存，做扣减完成");
            System.out.println();
            // 3. 扣减账号余额
            log.info("-------> 订单微服务开始调用Account账号，做扣减money");
            accountFeignApi.decrease(orderFrom.getUserId(), orderFrom.getMoney());
            log.info("-------> 订单微服务结束调用Account账号，做扣减完成");
            System.out.println();
            // 4. 修改订单状态
            // 订单状态status：0：创建中；1：已完结
            log.info("-------> 修改订单状态");
            orderFrom.setStatus(1);

            Example whereCondition = new Example(Order.class);
            Example.Criteria criteria = whereCondition.createCriteria();
            criteria.andEqualTo("userId", orderFrom.getUserId());
            criteria.andEqualTo("status", 0);

            int updateResult = orderMapper.updateByExampleSelective(orderFrom, whereCondition);

            log.info("-------> 修改订单状态完成" + "\t" + updateResult);
            log.info("-------> orderFrom info: " + orderFrom);
        }
        System.out.println();
        log.info("==================>结束新建订单" + "\t" + "xid_order:" + xid);
    }
}
