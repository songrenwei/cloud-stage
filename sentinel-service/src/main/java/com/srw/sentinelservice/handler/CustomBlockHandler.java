package com.srw.sentinelservice.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import net.dreamlu.mica.core.result.R;

/**
 * @Description:
 * @Author: songrenwei
 * @Date: 2020/12/3/15:16
 */
@Slf4j
public class CustomBlockHandler {

    //TODO 要为static不然找不到报错
    public static R handleException(BlockException exception){
        log.info("自定义限流信息---------");
        return R.success("自定义限流信息");
    }
}

