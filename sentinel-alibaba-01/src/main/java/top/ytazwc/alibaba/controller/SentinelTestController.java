package top.ytazwc.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ytazwc.alibaba.service.TestService;

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

    @Autowired
    private TestService testService;

    @GetMapping("/getTest")
    public String getTest() {
        return "sentinel success";
    }

    @GetMapping("/a")
    public String a() {
        testService.test();
        return "sentinel A success!";
    }

    @GetMapping("/b")
    public String b() {
        testService.test();
        return "sentinel B success!";
    }

}
