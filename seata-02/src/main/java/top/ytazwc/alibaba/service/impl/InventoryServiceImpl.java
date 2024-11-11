package top.ytazwc.alibaba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ytazwc.alibaba.bean.Inventory;
import top.ytazwc.alibaba.mapper.InventoryMapper;
import top.ytazwc.alibaba.service.InventoryService;

import java.util.Date;

/**
 * @author 花木凋零成兰
 * @title InventoryServiceImpl
 * @date 2024-11-11 10:38
 * @package top.ytazwc.alibaba.service.impl
 * @description
 */
@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public void reduceInventory(Long productId, Integer quantity) {
        // 扣减库存逻辑
        Inventory inventory = inventoryMapper.findByProductId(productId);
        if (inventory != null) {
            int used = inventory.getUsed() + quantity;
            int residue = inventory.getTotal() - used;
            if (residue < 0) {
                throw new RuntimeException("库存不足 !!!");
            }
            inventory.setUpdateTime(new Date());
            inventory.setUsed(used);
            inventory.setResidue(residue);
            inventoryMapper.updateInventory(inventory);
        } else {
            throw new RuntimeException("商品不存在!!!");
        }
    }

}
