package com.pinyougou.page.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;
import javax.xml.soap.Text;
import java.io.Serializable;

@Component
public class PageDeleteListener implements MessageListener {
    @Autowired
    private ItemPageServiceImpl itemPageService;


    @Override
    public void onMessage(Message message) {
        ObjectMessage objectMessage=(ObjectMessage)message;

        try {
            Long[] goodsIds = (Long[]) objectMessage.getObject();
            itemPageService.deleteItemHtml(goodsIds);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
