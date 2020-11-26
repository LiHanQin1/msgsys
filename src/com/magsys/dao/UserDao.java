package com.magsys.dao;

import com.magsys.enyity.User;

import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-11-26 18:08
 **/
public interface UserDao {
    int insert(User user);
    int update(User user);
    int delete(Integer id);
    List<User> queryAll();;
    User queryUserById( Integer id);
    User queryUserByNameAndPassword(User user);

}
