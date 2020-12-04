package com.srw.sentinelservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.srw.sentinelservice.handler.CustomBlockHandler;
import net.dreamlu.mica.core.result.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 限流功能
 * @Author: songrenwei
 * @Date: 2020/12/3/14:02
 */
@RestController
@RequestMapping("/rateLimit")
public class RateLimitController {

    /**
     * 按资源名称限流，需要指定限流处理逻辑
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public R byResource() {
        return R.success("按资源名称限流");
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl",blockHandler = "handleException")
    public R byUrl() {
        return R.success("按Url限流");
    }

    /**
     * 自定义通用的限流处理逻辑
     */
    @GetMapping("/customBlockHandler")
    @SentinelResource(value = "customBlockHandler", blockHandlerClass = CustomBlockHandler.class, blockHandler = "handleException")
    public R blockHandler() {
        return R.success("限流成功");
    }

    public R handleException(BlockException exception){
        return R.success(exception.getClass().getCanonicalName());
    }

}

