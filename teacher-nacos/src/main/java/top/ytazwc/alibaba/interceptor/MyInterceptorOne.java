package top.ytazwc.alibaba.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author 花木凋零成兰
 * @title MyInterceptorOne
 * @date 2024-11-09 23:08
 * @package top.ytazwc.alibaba.interceptor
 * @description
 */
public class MyInterceptorOne implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("one my interceptor");

    }
}
