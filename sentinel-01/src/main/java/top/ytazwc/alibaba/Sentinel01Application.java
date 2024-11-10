package top.ytazwc.alibaba;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Sentinel01Application {

    public static void main(String[] args) {
        SpringApplication.run(Sentinel01Application.class, args);
    }

    // 添加使用sentinel注解的bean
    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

}
