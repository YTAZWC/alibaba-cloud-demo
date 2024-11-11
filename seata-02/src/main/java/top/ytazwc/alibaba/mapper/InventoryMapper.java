package top.ytazwc.alibaba.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.ytazwc.alibaba.bean.Inventory;

/**
 * @author 花木凋零成兰
 * @title InventoryMapper
 * @date 2024-11-11 10:21
 * @package top.ytazwc.alibaba.mapper
 * @description
 */
@Mapper
public interface InventoryMapper {

    /**
     * 查找产品的库存
     * @param productId 产品id
     * @return 库存信息
     */
    Inventory findByProductId(Long productId);

    /**
     * 更新库存信息
     * @param inventory 新的库存信息
     */
    void updateInventory(Inventory inventory);

}
