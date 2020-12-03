package com.srw.nacosconsumer.controller;

import com.srw.nacosconsumer.client.UserClient;
import com.srw.nacosconsumer.domain.User;
import lombok.RequiredArgsConstructor;
import net.dreamlu.mica.core.result.R;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: songrenwei
 * @Date: 2020/11/24/15:24
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/nacos")
public class ConsumerFeignController {

    private final UserClient client;

    @GetMapping("/{id}")
    public R<User> getUser(@PathVariable Long id) {
        return client.getUser(id);
    }

    @GetMapping("/getByUsername")
    public R<User> getByUsername(@RequestParam String username) {
        return client.getByUsername(username);
    }

    @PostMapping("/create")
    public R<?> create(@RequestBody User user) {
        return client.create(user);
    }

    @PostMapping("/update")
    public R<?> update(@RequestBody User user) {
        return client.update(user);
    }

    @PostMapping("/delete/{id}")
    public R<?> delete(@PathVariable Long id) {
        return client.delete(id);
    }

}
