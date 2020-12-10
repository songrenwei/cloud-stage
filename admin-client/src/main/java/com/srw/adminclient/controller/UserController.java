package com.srw.adminclient.controller;

import com.srw.adminclient.domain.User;
import com.srw.adminclient.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dreamlu.mica.core.result.R;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by renwei.song on 2019/8/29.
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    
    private final UserService userService;

    @PostMapping("/create")
    public R create(@RequestBody User user) {
        userService.create(user);
        return R.success();
    }

    @GetMapping("/{id}")
    public R<User> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        log.info("根据id获取用户信息，用户名称为：{}",user.getUsername());
        return R.success(user);
    }

    @GetMapping("/getUserByIds")
    public R<List<User>> getUserByIds(@RequestParam List<Long> ids) {
        List<User> userList= userService.getUserByIds(ids);
        log.info("根据ids获取用户信息，用户列表为：{}",userList);
        return R.success(userList);
    }

    @GetMapping("/getByUsername")
    public R<User> getByUsername(@RequestParam String username) {
        User user = userService.getByUsername(username);
        return R.success(user);
    }

    @PostMapping("/update")
    public R update(@RequestBody User user) {
        userService.update(user);
        return R.success();
    }

    @PostMapping("/delete/{id}")
    public R delete(@PathVariable Long id) {
        userService.delete(id);
        return R.success();
    }
}
