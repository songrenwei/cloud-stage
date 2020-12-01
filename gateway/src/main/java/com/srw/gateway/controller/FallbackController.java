package com.srw.gateway.controller;

import net.dreamlu.mica.core.result.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: songrenwei
 * @Date: 2020/12/1/11:13
 */
@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public R fallback() {
        return R.fail("Get request fallback!");
    }

}

