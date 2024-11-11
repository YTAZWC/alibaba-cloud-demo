package top.ytazwc.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.ytazwc.alibaba.service.InventoryService;

/**
 * @author 花木凋零成兰
 * @title InventoryController
 * @date 2024-11-11 10:45
 * @package top.ytazwc.alibaba.controller
 * @description
 */
@RestController
@RequestMapping("/inventory")
@Slf4j
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/reduce")
    public ResponseEntity<String> reduceInventory(@RequestParam("productId") Long productId, @RequestParam("quantity") Integer quantity) {
        log.warn("start reduce inventory ... ");
        inventoryService.reduceInventory(productId, quantity);
        return ResponseEntity.ok("Inventory reduced successfully !");
    }

}
