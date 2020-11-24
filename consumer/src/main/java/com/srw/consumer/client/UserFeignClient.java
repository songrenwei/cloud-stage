package com.srw.consumer.client;

import com.srw.consumer.domain.User;
import com.srw.consumer.service.FallbackService;
import net.dreamlu.mica.core.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: songrenwei
 * @Date: 2020/11/23/14:50
 */
@FeignClient(value = "provider", fallback = FallbackService.class)
public interface UserFeignClient {

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
