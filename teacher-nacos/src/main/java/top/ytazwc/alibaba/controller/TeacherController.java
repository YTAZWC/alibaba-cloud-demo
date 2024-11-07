package top.ytazwc.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 花木凋零成兰
 * @title StudentController
 * @date 2024-11-07 23:15
 * @package top.ytazwc.alibaba.controller
 * @description
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get")
    public String getTeacher() {

        final RestTemplate restTemplate = new RestTemplate();

        // 获取服务实例
        ServiceInstance student = loadBalancerClient.choose("student");
        // 发送请求
        String forObject = restTemplate.getForObject("http://" + student.getHost() + ":" + student.getPort() + "/student/get", String.class);
        System.out.println(forObject + "//" + student.getHost() + "//" + student.getPort());
        return "teacher";
    }

    @GetMapping("/get2")
    public String getTeacher2() {

        String forObject = restTemplate.getForObject("http://student/student/get", String.class);
        System.out.println(forObject);

        return "teacher2";
    }

}
