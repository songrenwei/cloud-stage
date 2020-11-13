package com.srw.eurekaconsumer.controller;

import com.srw.eurekaconsumer.client.HelloClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: 消费者
 * @Author: songrenwei
 * @Date: 2020/11/5/14:53
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class ConsumerController {
    private final RestTemplate restTemplate;
    private final HelloClient helloClient;

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name") String name){
        log.info("name: {}", name);
//        return restTemplate.getForObject("http://EUREKA-PROVIDER/hello?name=" + name, String.class);
        return helloClient.helloWorld(name);
    }

}
