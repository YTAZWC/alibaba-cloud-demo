package top.ytazwc.alibaba.config;

import org.springframework.context.annotation.Bean;
import top.ytazwc.alibaba.interceptor.MyInterceptorOne;
import top.ytazwc.alibaba.interceptor.MyInterceptorTwo;

/**
 * @author 花木凋零成兰
 * @title FeignInterceptorConfig
 * @date 2024-11-09 23:12
 * @package top.ytazwc.alibaba.config
 * @description
 */
public class FeignInterceptorConfig {

    /* 拦截器的拦截顺序 按照从上到下顺序 */

    @Bean
    public MyInterceptorOne myInterceptorOne() {
        return new MyInterceptorOne();
    }

    @Bean
    public MyInterceptorTwo myInterceptorTwo() {
        return new MyInterceptorTwo();
    }
}
