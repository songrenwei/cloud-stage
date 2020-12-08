package com.srw.cloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.srw.cloud.dao"})
public class MyBatisConfig {
}
