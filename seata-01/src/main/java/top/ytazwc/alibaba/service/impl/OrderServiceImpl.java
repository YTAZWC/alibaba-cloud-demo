package top.ytazwc.alibaba.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ytazwc.alibaba.bean.Order;
import top.ytazwc.alibaba.feign.InventoryFeignClient;
import top.ytazwc.alibaba.mapper.OrderMapper;
import top.ytazwc.alibaba.service.OrderService;

import java.util.Date;

/**
 * @author 花木凋零成兰
 * @title OrderServiceImpl
 * @date 2024-11-11 10:34
 * @package top.ytazwc.alibaba.service.impl
 * @description
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private InventoryFeignClient inventoryFeignClient;

    @GlobalTransactional    // 全局分布式事务
    @Override
    public void createOrder(Order order) {
        // 创建订单逻辑
        // 设置订单状态为 待支付
        order.setStatus(0);
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        orderMapper.createOrder(order);
        // 调用库存服务减少库存
        inventoryFeignClient.reduceInventory(order.getProductId(), order.getCount());
        int i = 1/0;
    }

}
