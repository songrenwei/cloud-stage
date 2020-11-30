package com.srw.eurekaconsumer.controller;

import com.srw.eurekaconsumer.client.UserRibbonClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dreamlu.mica.core.result.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: Hystrix测试
 * @Author: songrenwei
 * @Date: 2020/11/23/14:25
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/hystrix")
public class ConsumerHystrixController {

    private final UserRibbonClient client;

    @GetMapping("/testFallback/{id}")
    public R testFallback(@PathVariable Long id) {
        return client.getUser(id);
    }

    @GetMapping("/testCommand/{id}")
    public R testCommand(@PathVariable Long id) {
        return client.getUserCommand(id);
    }

    @GetMapping("/testException/{id}")
    public R testException(@PathVariable Long id) {
        return client.getUserException(id);
    }


    @GetMapping("/testCache/{id}")
    public R testCache(@PathVariable Long id) {
        R r1 = client.getUserCache(id);
        R r2 = client.getUserCache(id);
        R r3 = client.getUserCache(id);
        log.info("r1: "+r1);
        log.info("r2: "+r1);
        log.info("r3: "+r1);
        return R.success();
    }

    @GetMapping("/testRemoveCache/{id}")
    public R testRemoveCache(@PathVariable Long id) {

        return R.success(client.removeCache(id));
    }

}
