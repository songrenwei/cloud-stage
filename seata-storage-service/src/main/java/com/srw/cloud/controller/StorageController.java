package com.srw.cloud.controller;

import com.srw.cloud.service.StorageService;
import lombok.RequiredArgsConstructor;
import net.dreamlu.mica.core.result.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/storage")
public class StorageController {

    private final StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/decrease")
    public R decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return R.success("扣减库存成功！");
    }
}
