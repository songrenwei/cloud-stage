package com.srw.sentinelservice.service;

import com.srw.sentinelservice.client.UserClient;
import com.srw.sentinelservice.domain.User;
import net.dreamlu.mica.core.result.R;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: songrenwei
 * @Date: 2020/12/4/13:57
 */
@Component
public class FallbackService implements UserClient {
    @Override
    public R create(User user) {
        return R.success("服务降级返回");
    }

    @Override
    public R<User> getUser(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return R.success(defaultUser);
    }

    @Override
    public R<User> getByUsername(String username) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return R.success(defaultUser);
    }

    @Override
    public R update(User user) {
        return R.success("服务降级返回");
    }

    @Override
    public R delete(Long id) {
        return R.success("服务降级返回");
    }
}
