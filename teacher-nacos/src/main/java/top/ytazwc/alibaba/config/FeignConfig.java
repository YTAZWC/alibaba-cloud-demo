package top.ytazwc.alibaba.config;

import feign.Logger;
import feign.Request.Options;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author 花木凋零成兰
 * @title FeignConfig
 * @date 2024-11-08 23:47
 * @package top.ytazwc.alibaba.config
 * @description 配置openfeign日志和超时与读取时间
 */
@Configuration
@Import({FeignInterceptorConfig.class})
public class FeignConfig {

    @Bean
    public Options options() {
        // 设置连接和读取超时时间
        return new Options(5000, 10000);
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        // 设置日志级别为详细
        return Logger.Level.FULL;
    }

}
