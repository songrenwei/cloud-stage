package com.srw.consulconsumer.service;

import com.srw.consulconsumer.client.UserClient;
import com.srw.consulconsumer.domain.User;
import net.dreamlu.mica.core.result.R;
import org.springframework.stereotype.Component;

/**
 * @Description: feign服务降级
 * @Author: songrenwei
 * @Date: 2020/11/24/15:42
 */

/**
 * Created by renwei.song on 2019/9/5.
 */
@Component
public class FallbackService implements UserClient {
    @Override
    public R<?> create(User user) {
        return R.fail("服务降级");
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
        return R.fail("服务降级");
    }

    @Override
    public R delete(Long id) {
        return R.fail("服务降级");
    }
}

