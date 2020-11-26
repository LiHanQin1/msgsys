package com.magsys.service.impl;

import com.magsys.dao.MessageDao;
import com.magsys.dao.impl.MessageDaoImpl;
import com.magsys.enyity.Message;
import com.magsys.service.MessageService;

import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-11-26 23:29
 **/
public class MessageServiceImpl implements MessageService {
    MessageDao messageDao=new MessageDaoImpl();
    @Override
    public List<Message> queryMessageByToUid(Integer id) {
        return messageDao.queryMessageByToUid(id);
    }

    @Override
    public Message queryMessageById(Integer id) {
        return messageDao.queryMessageById(id);
    }
}
