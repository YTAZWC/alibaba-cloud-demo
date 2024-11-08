package top.ytazwc.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author hoshino
 */
@SpringBootApplication
@EnableFeignClients // 启动openfeign扫描
public class TeacherNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeacherNacosApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
