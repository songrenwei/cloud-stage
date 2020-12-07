package com.srw.seataorderservice.service;

import com.srw.seataorderservice.domain.Order;

public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
