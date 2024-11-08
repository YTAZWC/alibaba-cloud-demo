package top.ytazwc.alibaba.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 花木凋零成兰
 * @title StudentFeign
 * @date 2024-11-08 22:23
 * @package top.ytazwc.alibaba.feign
 * @description 远程调用 Student 服务
 */
@FeignClient(value = "student", path = "/student") // 值为student服务名
public interface StudentFeign {

    @GetMapping("/get")
    String getStudent();

}
