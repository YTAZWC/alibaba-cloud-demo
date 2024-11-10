package top.ytazwc.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 花木凋零成兰
 * @title SentinelTestController
 * @date 2024-11-10 13:51
 * @package top.ytazwc.alibaba.controller
 * @description 测试sentinel整合cloud控制类
 */
@RestController
@RequestMapping("/sentinel")
public class SentinelTestController {

    @GetMapping("/getTest")
    public String getTest() {
        return "sentinel success";
    }

}
