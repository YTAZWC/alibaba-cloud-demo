package top.ytazwc.alibaba.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.ytazwc.alibaba.bean.Order;

/**
 * @author 花木凋零成兰
 * @title OrderMapper
 * @date 2024-11-11 10:20
 * @package top.ytazwc.alibaba.mapper
 * @description
 */
@Mapper
public interface OrderMapper {

    /**
     * 创建订单
     * @param order 订单信息
     */
    void createOrder(Order order);

}
