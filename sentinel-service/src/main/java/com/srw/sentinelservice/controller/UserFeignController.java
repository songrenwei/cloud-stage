package com.srw.sentinelservice.controller;

import com.srw.sentinelservice.client.UserClient;
import com.srw.sentinelservice.domain.User;
import lombok.RequiredArgsConstructor;
import net.dreamlu.mica.core.result.R;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: songrenwei
 * @Date: 2020/12/4/13:54
 */
/**
 * Created by macro on 2019/8/29.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserFeignController {

    private final UserClient userClient;

    @GetMapping("/{id}")
    public R getUser(@PathVariable Long id) {
        return userClient.getUser(id);
    }

    @GetMapping("/getByUsername")
    public R getByUsername(@RequestParam String username) {
        return userClient.getByUsername(username);
    }

    @PostMapping("/create")
    public R create(@RequestBody User user) {
        return userClient.create(user);
    }

    @PostMapping("/update")
    public R update(@RequestBody User user) {
        return userClient.update(user);
    }

    @PostMapping("/delete/{id}")
    public R delete(@PathVariable Long id) {
        return userClient.delete(id);
    }
}

