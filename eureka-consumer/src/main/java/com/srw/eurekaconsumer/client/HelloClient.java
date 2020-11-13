package com.srw.eurekaconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: client
 * @Author: songrenwei
 * @Date: 2020/11/6/16:31
 */
@FeignClient(name = "eureka-provider")
public interface HelloClient {

    @RequestMapping("/hello")
    String helloWorld(@RequestParam("name") String name);

}
