package top.ytazwc.alibaba.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author 花木凋零成兰
 * @title Inventory
 * @date 2024-11-11 10:16
 * @package top.ytazwc.alibaba.bean
 * @description 库存表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Inventory {
    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;
    private Date createTime;
    private Date updateTime;
}
