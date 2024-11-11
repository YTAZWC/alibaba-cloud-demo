package top.ytazwc.alibaba.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 花木凋零成兰
 * @title Order
 * @date 2024-11-11 10:14
 * @package top.ytazwc.alibaba.bean
 * @description 订单表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {

    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal amount;
    private Integer status;
    private Date createTime;
    private Date updateTime;

}
