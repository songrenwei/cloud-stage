package com.srw.consumer.service;

import com.srw.consumer.client.UserFeignClient;
import com.srw.consumer.domain.User;
import net.dreamlu.mica.core.result.R;
import org.springframework.stereotype.Component;

/**
 * @Description: feign服务降级
 * @Author: songrenwei
 * @Date: 2020/11/24/15:42
 */
/**
 * Created by macro on 2019/9/5.
 */
@Component
public class FallbackService implements UserFeignClient {
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
