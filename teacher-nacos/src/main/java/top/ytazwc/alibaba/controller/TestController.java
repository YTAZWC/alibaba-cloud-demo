package top.ytazwc.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 花木凋零成兰
 * @title TestController
 * @date 2024-11-08 21:00
 * @package top.ytazwc.alibaba.controller
 * @description
 */
@RestController
@RequestMapping("/test")
/*
在微服务架构中，应用的配置信息可能会经常发生变化；
如果不使用动态刷新机制，应用在启动时加载一次配置，
之后不会主动去获取最新的配置值，会导致配置的变更在不重启应用的情况下不会生效；
@RefreshScope 注解能够使应用在运行时检测到配置的变更并重新加载配置，而不需要重启应用
*/
@RefreshScope
public class TestController {

    @Value("${test}")
    private String configValue;

    @Value("${teacher-test}")
    private String configProperties;

    @GetMapping("/config")
    public String getConfigValue() {
        return configValue + ":" + configProperties;
    }

    @GetMapping("/properties")
    public String getConfigProperties() {
        return configProperties;
    }

}
