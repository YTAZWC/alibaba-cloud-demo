package top.ytazwc.alibaba.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 花木凋零成兰
 * @title MyCustomGatewayFilterFactory
 * @date 2024-11-11 22:54
 * @package top.ytazwc.alibaba.filter
 * @description
 */
@Component
public class MyCustomGatewayFilterFactory extends AbstractGatewayFilterFactory<MyCustomGatewayFilterFactory.Config> {

    public MyCustomGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return List.of("customHeaderName", "customHeaderValue");
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            // 编写自定义的过滤逻辑
            // 使用配置属性来定制过滤器的行为
            String customHeaderName = config.getCustomHeaderName();
            String customHeaderValue = config.getCustomHeaderValue();
            // 添加自定义请求头
            exchange.getRequest().mutate().header(customHeaderName, customHeaderValue);
            // 继续执行过滤器链
            return chain.filter(exchange);
        });
    }

    public static class Config {
        private String customHeaderName = "x-Custom-Header";
        private String customHeaderValue = "Custom-Value";

        public String getCustomHeaderName() {
            return customHeaderName;
        }

        public void setCustomHeaderName(String customHeaderName) {
            this.customHeaderName = customHeaderName;
        }

        public String getCustomHeaderValue() {
            return customHeaderValue;
        }

        public void setCustomHeaderValue(String customHeaderValue) {
            this.customHeaderValue = customHeaderValue;
        }
    }
}
