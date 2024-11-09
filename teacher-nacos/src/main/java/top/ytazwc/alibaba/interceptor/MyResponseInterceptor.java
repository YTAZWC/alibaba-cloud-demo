package top.ytazwc.alibaba.interceptor;

import feign.InvocationContext;
import feign.Request;
import feign.Response;
import feign.ResponseInterceptor;
import feign.codec.Decoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Map;

/**
 * @author 花木凋零成兰
 * @title MyResponseInterceptor
 * @date 2024-11-09 23:23
 * @package top.ytazwc.alibaba.interceptor
 * @description 响应结果拦截器
 */
@Component
public class MyResponseInterceptor implements ResponseInterceptor {

    @Autowired
    private Decoder decoder;

    @Override
    public Object aroundDecode(InvocationContext invocationContext) throws IOException {
        // 获取原始响应结果
        Response response = invocationContext.response();
        // 获取响应的请求
        Request request = response.request();
        // 获取响应状态码
        int status = response.status();
        // 获取响应的原因
        String reason = response.reason();
        // 获取响应头
        Map<String, Collection<String>> headers = response.headers();

        // 创建新的响应结果对象 并设置修改后的响应内容
        Response modifiedResponse = Response.builder()
                .status(status)
                .reason(reason)
                .headers(headers)
                .body("modifiled response content", StandardCharsets.UTF_8)
                .request(request)
                .build();

        return decoder.decode(modifiedResponse, invocationContext.returnType());
    }
}
