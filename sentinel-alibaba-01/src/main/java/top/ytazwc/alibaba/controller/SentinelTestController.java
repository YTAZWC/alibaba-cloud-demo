package top.ytazwc.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ytazwc.alibaba.service.TestService;

/**
 * @author 花木凋零成兰
 * @title SentinelTestController
 * @date 2024-11-10 13:51
 * @package top.ytazwc.alibaba.controller
 * @description 测试sentinel整合cloud控制类
 */
@RestController
@RequestMapping("/sentinel")
public class SentinelTestController {

    @Autowired
    private TestService testService;

    @GetMapping("/getTest")
    public String getTest() throws InterruptedException {
        // 增加请求延迟 方便测试熔断规则
        Thread.sleep(2000);
        return "sentinel success";
    }

    @GetMapping("/a")
    public String a() {
        testService.test();
        // 添加异常 测试熔断规则
        int a = 1/0;
        return "sentinel A success!";
    }

    @GetMapping("/b")
    public String b() {
        testService.test();
        return "sentinel B success!";
    }

    // 测试热点参数限流
    @GetMapping("/id/{id}")
    @SentinelResource(value = "id", blockHandler = "handlerBlock")
    public String id(@PathVariable("id") int id) {
        System.out.println("id: " + id);
        return "sentinel id success ... ";
    }

    private String handlerBlock(@PathVariable("id") int id, BlockException ex) {
        // 被流控时的处理逻辑
        return "sentinel id blocked ...";
    }

}
