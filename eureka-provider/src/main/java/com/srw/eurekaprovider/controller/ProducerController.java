package com.srw.eurekaprovider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: songrenwei
 * @Date: 2020/11/5/14:03
 */
@Slf4j
@RestController
public class ProducerController {

    @RequestMapping("/hello")
    public String helloWorld(@RequestParam("name") String name){
        log.info("传入的值为:{}", name);
        return "传入的值为："+name;
    }
}
