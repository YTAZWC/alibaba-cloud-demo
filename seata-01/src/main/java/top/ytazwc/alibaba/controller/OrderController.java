package top.ytazwc.alibaba.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import top.ytazwc.alibaba.bean.Order;
import top.ytazwc.alibaba.service.OrderService;

import java.util.Map;

/**
 * @author 花木凋零成兰
 * @title OrderController
 * @date 2024-11-11 10:43
 * @package top.ytazwc.alibaba.controller
 * @description
 */
@RestController
//@RequestMapping("/order")
@RequestMapping("/new-path")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return ResponseEntity.ok("Order created successfully !");
    }

    @GetMapping("/getHeaders")
    public Map<String, String> getHeaders(@RequestHeader Map<String, String> headers) {
        return headers;
    }

    @GetMapping("/test-rewrite")
    public Mono<String> testRewritePath(HttpServletRequest request) {
        String requestPath = request.getRequestURI();
        return Mono.just("Request Path: " + requestPath);
    }

}
