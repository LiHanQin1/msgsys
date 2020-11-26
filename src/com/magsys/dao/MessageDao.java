package com.magsys.dao;

import com.magsys.enyity.Message;
import com.magsys.enyity.User;

import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-11-26 18:08
 **/
public interface MessageDao {
    int insert(Message message);

    int update(Message message);

    int delete(Integer id);

    List<Message> queryAll();

    Message queryMessageById(Integer id);

    //根据收信人id 查询邮件
    List<Message> queryMessageByToUid(Integer id);
}
