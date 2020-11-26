package com.magsys.service;

import com.magsys.enyity.User;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-11-26 18:51
 **/
public interface UserService {
    //注册
    int register(User user);
    //登录
    User login(User user);
}
