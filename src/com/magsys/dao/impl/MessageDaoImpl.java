package com.magsys.dao.impl;

import com.magsys.dao.BaseDao;
import com.magsys.dao.MessageDao;
import com.magsys.enyity.Message;

import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-11-26 18:26
 **/
public class MessageDaoImpl extends BaseDao implements MessageDao {
    @Override
    public int insert(Message message) {
        String sql = "insert into T_msg (fromUid,toUid,mTitle,mContent,readFlag,createTime)values(?,?,?,?,?,?)";
        return update(sql, message.getFromUid(), message.getToUid(), message.getmTitle(), message.getmContent(), message.getReadFlag(), message.getCreateTime());
    }

    @Override
    public int update(Message message) {
        String sql = "update T_msg set fromUid=?,toUid=?,mTitle=?,mContent=?,readFlag=?,createTime=? where id=?";
        return update(sql, message.getFromUid(), message.getToUid(), message.getmTitle(), message.getmContent(), message.getReadFlag(), message.getCreateTime(), message.getId());
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from T_msg where id=?";
        return update(sql, id);
    }

    @Override
    public List<Message> queryAll() {
        String sql = "select *from T_msg";

        return queryForList(Message.class, sql);
    }

    @Override
    public Message queryMessageById(Integer id) {
        String sql = "select *from T_msg where id= ?";
        return queryForOne(Message.class, sql,id);
    }

    @Override
    public List<Message> queryMessageByToUid(Integer id) {
        String sql = "select *from T_msg where toUid= ?";

        return queryForList(Message.class, sql,id);
    }
}
