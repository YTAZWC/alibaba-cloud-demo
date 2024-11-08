package top.ytazwc.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 花木凋零成兰
 * @title StudentController
 * @date 2024-11-07 23:15
 * @package top.ytazwc.alibaba.controller
 * @description
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/get")
    public String getStudent() throws InterruptedException {
        // 测试远程请求超时
//        Thread.sleep(6000);
        return "student";
    }

}
