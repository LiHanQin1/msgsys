package com.magsys.service.impl;

import com.magsys.dao.UserDao;
import com.magsys.dao.impl.UserDaoImpl;
import com.magsys.enyity.User;
import com.magsys.service.UserService;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-11-26 18:55
 **/
public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    @Override
    public int register(User user) {
        return userDao.insert(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByNameAndPassword(user);
    }
}
