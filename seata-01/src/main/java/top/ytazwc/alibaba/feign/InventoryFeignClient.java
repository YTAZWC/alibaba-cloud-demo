package top.ytazwc.alibaba.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 花木凋零成兰
 * @title InventoryFeignClient
 * @date 2024-11-11 10:31
 * @package top.ytazwc.alibaba.feign
 * @description 远程调用库存服务客户端
 */
@FeignClient(name = "inventory-service", path = "/inventory")
public interface InventoryFeignClient {

    @PostMapping("/reduce")
    void reduceInventory(@RequestParam("productId") Long productId, @RequestParam("quantity") Integer quantity);

}
