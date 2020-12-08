package com.srw.cloud.controller;

import com.srw.cloud.domain.Order;
import com.srw.cloud.service.OrderService;
import lombok.RequiredArgsConstructor;
import net.dreamlu.mica.core.result.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/create")
    public R create(Order order) {
        orderService.create(order);
        return R.success("订单创建成功!");
    }
}
