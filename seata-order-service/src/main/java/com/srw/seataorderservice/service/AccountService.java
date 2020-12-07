package com.srw.seataorderservice.service;

import net.dreamlu.mica.core.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "seata-account-service")
public interface AccountService {

    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    R decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
