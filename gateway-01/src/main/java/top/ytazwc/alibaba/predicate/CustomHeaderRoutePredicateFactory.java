package top.ytazwc.alibaba.predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author 花木凋零成兰
 * @title CustomHeaderRoutePredicateFactory
 * @date 2024-11-11 22:21
 * @package top.ytazwc.alibaba.predicate
 * @description 实现自定义路由规则
 * 1、创建一个类继承 org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory
 */
@Component  // 在配置文件中配置断言时 只需要截取RoutePredicateFactory之前的一段CustomHeader作为配置属性名即可
public class CustomHeaderRoutePredicateFactory extends AbstractRoutePredicateFactory<CustomHeaderRoutePredicateFactory.Config> {


    // 构造函数
    public CustomHeaderRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        // 该方法用于指定配置属性的字段顺序；
        // 返回一个字符串列表 字符串代表了配置属性的名称
        return List.of("headerName");
    }

    // 该方法编写自定义的路由断言逻辑
    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        // 编写自定义的断言逻辑
        // 检查请求头中是否包含特定标头名
        return exchange -> {
            return exchange.getRequest().getHeaders().containsKey(config.getHeaderName());
        };
    }

    // 配置模板的定义类 用于存储配置属性
    public static class Config {
        private String headerName;

        public String getHeaderName() {
            return headerName;
        }

        public void setHeaderName(String headerName) {
            this.headerName = headerName;
        }
    }
}
