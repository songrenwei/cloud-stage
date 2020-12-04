package com.srw.sentinelservice.client;

import com.srw.sentinelservice.domain.User;
import com.srw.sentinelservice.service.FallbackService;
import net.dreamlu.mica.core.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: TODO
 * @Author: songrenwei
 * @Date: 2020/11/30/16:59
 */
@FeignClient(value = "nacos-provider", fallback = FallbackService.class)
public interface UserClient {

    @PostMapping("/user/create")
    R<?> create(@RequestBody User user);

    @GetMapping("/user/{id}")
    R<User> getUser(@PathVariable Long id);

    @GetMapping("/user/getByUsername")
    R<User> getByUsername(@RequestParam String username);

    @PostMapping("/user/update")
    R<?> update(@RequestBody User user);

    @PostMapping("/user/delete/{id}")
    R<?> delete(@PathVariable Long id);

}
