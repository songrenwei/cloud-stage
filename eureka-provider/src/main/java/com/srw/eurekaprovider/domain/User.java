package com.srw.eurekaprovider.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description: TODO
 * @Author: songrenwei
 * @Date: 2020/11/23/10:51
 */
@Getter
@Setter
@AllArgsConstructor
public class User {

    private Long id;
    private String username;
    private String password;

}
