package top.ytazwc.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Seata01Application {

    public static void main(String[] args) {
        SpringApplication.run(Seata01Application.class, args);
    }

}
