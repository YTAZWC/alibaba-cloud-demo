package top.ytazwc.alibaba.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

/**
 * @author 花木凋零成兰
 * @title TestService
 * @date 2024-11-10 15:42
 * @package top.ytazwc.alibaba.service
 * @description
 */
@Service
public class TestService {

    @SentinelResource(value = "Test", blockHandler = "handlerBlock")
    public void test() {
        System.out.println("TestService test method ...");
    }

    private void handlerBlock(BlockException ex) {
        // 被流控时的处理逻辑
        System.out.println("test method handlerBlock ...");
    }

}
