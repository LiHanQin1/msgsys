package com.magsys.service;

import com.magsys.enyity.Message;

import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-11-26 23:25
 **/
public interface MessageService {
    //根据受信人的ID查询邮件
    List<Message> queryMessageByToUid(Integer id);

    //根据id查询邮件详情
    Message queryMessageById(Integer id);

}
