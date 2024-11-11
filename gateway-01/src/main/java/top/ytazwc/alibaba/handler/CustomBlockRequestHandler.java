package top.ytazwc.alibaba.handler;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author 花木凋零成兰
 * @title CustomBlockRequestHandler
 * @date 2024-11-11 23:19
 * @package top.ytazwc.alibaba.handler
 * @description 自定义的限流异常处理器
 */
@Configuration
public class CustomBlockRequestHandler implements BlockRequestHandler {
    @Override
    public Mono<ServerResponse> handleRequest(ServerWebExchange serverWebExchange, Throwable throwable) {
        return Mono.defer(() -> ServerResponse
                .status(HttpStatus.TOO_MANY_REQUESTS)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("请求太多次了, 请稍后重试 !!!")
        );
    }
}
