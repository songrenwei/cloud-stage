package com.srw.eurekaprovider.service;

import com.srw.eurekaprovider.domain.User;

import java.util.List;

/**
 * @Description:
 * @Author: songrenwei
 * @Date: 2020/11/23/10:48
 */
public interface UserService {

    void create(User user);

    User getUser(Long id);

    void update(User user);

    void delete(Long id);

    User getByUsername(String username);

    List<User> getUserByIds(List<Long> ids);
}
