package com.srw.consumer.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.srw.consumer.domain.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dreamlu.mica.core.result.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description: client
 * @Author: songrenwei
 * @Date: 2020/11/6/16:31
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserRibbonClient {

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    private final RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getDefaultUser")
    public R getUser(Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", R.class, id);
    }

    public R getDefaultUser(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return R.success(defaultUser);
    }

    @HystrixCommand(fallbackMethod = "getDefaultUser",
            commandKey = "getUserCommand",
            groupKey = "getUserGroup",
            threadPoolKey = "getUserThreadPool")
    public R getUserCommand(@PathVariable Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", R.class, id);
    }

    @HystrixCommand(fallbackMethod = "getDefaultUser2", ignoreExceptions = {NullPointerException.class})
    public R getUserException(Long id) {
        if (id == 1) {
            throw new IndexOutOfBoundsException();
        } else if (id == 2) {
            throw new NullPointerException();
        }
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", R.class, id);
    }

    public R getDefaultUser2(@PathVariable Long id, Throwable e) {
        log.error("getDefaultUser2 id:{},throwable class:{}", id, e.getClass());
        User defaultUser = new User(-2L, "defaultUser2", "123456");
        return R.success(defaultUser);
    }


    @CacheResult(cacheKeyMethod = "getCacheKey")
    @HystrixCommand(fallbackMethod = "getDefaultUser", commandKey = "getUserCache")
    public R getUserCache(Long id) {
        log.info("getUserCache id:{}", id);
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", R.class, id);
    }
    /**
     * 为缓存生成key的方法
     */
    public String getCacheKey(Long id) {
        return String.valueOf(id);
    }



    @CacheRemove(commandKey = "getUserCache", cacheKeyMethod = "getCacheKey")
    @HystrixCommand
    public R removeCache(Long id) {
        log.info("removeCache id:{}", id);
        return restTemplate.postForObject(userServiceUrl + "/user/delete/{1}", null, R.class, id);
    }















    public R getUserWithFallback(Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", R.class, id);
    }

    public R getByUsername(String username) {
        return restTemplate.getForObject(userServiceUrl + "/user/getByUsername?username={1}", R.class, username);
    }

    public R getEntityByUsername(String username) {
        ResponseEntity<R> entity = restTemplate.getForEntity(userServiceUrl + "/user/getByUsername?username={1}", R.class, username);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return R.fail("操作失败");
        }
    }

    public R create(User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/create", user, R.class);
    }

    public R update(User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/update", user, R.class);
    }

    public R delete(Long id) {
        return restTemplate.postForObject(userServiceUrl + "/user/delete/{1}", null, R.class, id);
    }

}
