package top.ytazwc.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ytazwc.alibaba.bean.Order;
import top.ytazwc.alibaba.service.OrderService;

/**
 * @author 花木凋零成兰
 * @title OrderController
 * @date 2024-11-11 10:43
 * @package top.ytazwc.alibaba.controller
 * @description
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return ResponseEntity.ok("Order created successfully !");
    }

}
