package com.srw.eurekaconsumer.controller;

import com.srw.eurekaconsumer.client.UserRibbonClient;
import com.srw.eurekaconsumer.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dreamlu.mica.core.result.R;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: Ribbon测试
 * @Author: songrenwei
 * @Date: 2020/11/5/14:53
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/ribbon")
public class ConsumerRibbonController {

    private final UserRibbonClient client;


    @GetMapping("/{id}")
    public R getUser(@PathVariable Long id) {
        return client.getUserWithFallback(id);
    }

    @GetMapping("/getByUsername")
    public R getByUsername(@RequestParam String username) {
        return client.getByUsername(username);
    }

    @GetMapping("/getEntityByUsername")
    public R getEntityByUsername(@RequestParam String username) {
        return client.getEntityByUsername(username);
    }

    @PostMapping("/create")
    public R create(@RequestBody User user) {
        return client.create(user);
    }

    @PostMapping("/update")
    public R update(@RequestBody User user) {
        return client.update(user);
    }

    @PostMapping("/delete/{id}")
    public R delete(@PathVariable Long id) {
        return client.delete(id);
    }

}
