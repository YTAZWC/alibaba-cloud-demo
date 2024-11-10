package top.ytazwc.alibaba.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import com.alibaba.csp.sentinel.util.StringUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * @author 花木凋零成兰
 * @title HeaderOriginParser
 * @date 2024-11-10 19:27
 * @package top.ytazwc.alibaba.handler
 * @description 获取请求来源并做出判断
 */
@Component
public class HeaderOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        // 1. 从请求头中获取origin
        String origin = httpServletRequest.getHeader("origin");
        // 2. 非空判断
        if (StringUtil.isBlank(origin)) {
            origin = "blank";
        }
        return origin;
    }
}
