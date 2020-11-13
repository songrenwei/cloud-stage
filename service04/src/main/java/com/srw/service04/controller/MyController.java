package com.srw.service04.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: songrenwei
 * @Date: 2020/11/13/9:28
 */
@RestController
public class MyController {

    @RequestMapping("/hello")
    public String hello() {
        return "this is service4";
    }
}
