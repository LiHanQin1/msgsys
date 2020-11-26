package com.magsys.dao.impl;

import com.magsys.dao.BaseDao;
import com.magsys.dao.UserDao;
import com.magsys.enyity.User;

import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-11-26 18:25
 **/
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int insert(User user) {
        String sql = "INSERT INTO T_user (username,password,email)values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }



    @Override
    public int update(User user) {
        String sql = "update T_user set username=?,password=?,email=? where id=?";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getId());
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from T_user where id=?";
        return update(sql, id);
    }

    @Override
    public List<User> queryAll() {
        String sql = "select *from T_user";
        return queryForList(User.class, sql);
    }

    @Override
    public User queryUserById(Integer id) {
        String sql = "select *from T_user where id=?";
        return queryForOne(User.class, sql, id);

    }

    @Override
    public User queryUserByNameAndPassword(User user) {
        String sql = "select *from T_user where username=? and password =?";
        return queryForOne(User.class, sql, user.getUsername(), user.getPassword());
    }
}
