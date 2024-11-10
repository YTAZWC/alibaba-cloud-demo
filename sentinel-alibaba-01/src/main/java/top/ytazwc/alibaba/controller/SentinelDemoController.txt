package top.ytazwc.alibaba.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * @author 花木凋零成兰
 * @title SentinelDemoController
 * @date 2024-11-10 13:18
 * @package top.ytazwc.alibaba.controller
 * @description Sentinel 示例控制器
 */
@RestController
public class SentinelDemoController {

    // 初始化流量控制规则
    @PostConstruct
    public static void initFlowRules() {
        // 配置规则
        FlowRule rule = new FlowRule();
        // 设置资源名称/接口名
        rule.setResource("your-resource-name");
        // 设置限流的维度 为按照QPS限流
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置允许的最大QPS
        rule.setCount(1);
        // 流量控制来源
        rule.setLimitApp("default");
        // 设置流量控制策略
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);
        // 添加规则
        FlowRuleManager.loadRules(Collections.singletonList(rule));
        // ... 启动应用程序 开始接受流量
    }

    // 测试接口
    @GetMapping("/test-sentinel")
    public String sentinelTest() {
        try (
                Entry entry = SphU.entry("your-resource-name");
        ) {
            // 执行 需要受到流量控制的操作
            return "sentinel success";
        } catch (BlockException e) {
            // 被流量控制时 需要执行的逻辑
            return "sentinel blocked";
        }
    }

    // 测试使用注解使用流量控制
    @GetMapping("/test-annotation-sentinel")
    @SentinelResource(value = "your-resource-name", blockHandler = "block")
    public String annotationSentinelTest() {

        return "sentinel annotation success";
    }

    private String block(BlockException blockException) {
        return "annotation blocked";
    }

}
