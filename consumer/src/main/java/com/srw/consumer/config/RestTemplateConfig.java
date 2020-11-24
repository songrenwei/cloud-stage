package com.srw.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: 配置
 * @Author: songrenwei
 * @Date: 2020/11/5/15:01
 */
@Configuration
public class RestTemplateConfig {

    @LoadBalanced  //使用负载均衡机制
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
