package top.ytazwc.alibaba.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author 花木凋零成兰
 * @title MyInterceptorTwo
 * @date 2024-11-09 23:08
 * @package top.ytazwc.alibaba.interceptor
 * @description
 */

public class MyInterceptorTwo implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("two my interceptor");
        // 修改请求方法为POST
//        requestTemplate.method(Request.HttpMethod.POST);
    }
}
