package top.ytazwc.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ytazwc.alibaba.feign.StudentFeign;

/**
 * @author 花木凋零成兰
 * @title TestFeignController
 * @date 2024-11-08 22:25
 * @package top.ytazwc.alibaba.controller
 * @description
 */
@RestController
@RequestMapping("/feign")
public class TestFeignController {

    @Autowired
    private StudentFeign studentFeign;

    @GetMapping("/get")
    public String getFeign() {
//        log.debug("远程调用getStudent: {}", studentFeign.getStudent());
        System.out.println(studentFeign.getStudent());
        return "teacher openFeign student";
    }

}
