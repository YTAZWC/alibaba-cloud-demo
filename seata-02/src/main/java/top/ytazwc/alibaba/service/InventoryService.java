package top.ytazwc.alibaba.service;

/**
 * @author 花木凋零成兰
 * @title InventoryService
 * @date 2024-11-11 10:38
 * @package top.ytazwc.alibaba.service
 * @description
 */
public interface InventoryService {

    public void reduceInventory(Long productId, Integer quantity);

}
