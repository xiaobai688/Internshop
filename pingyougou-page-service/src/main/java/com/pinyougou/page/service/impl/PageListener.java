package com.pinyougou.page.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class PageListener implements MessageListener {

    @Autowired
    private ItemPageServiceImpl itemPageService;

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage=(TextMessage)message;
        try {
            String goodsId = textMessage.getText();
            itemPageService.genItemHtml(Long.parseLong(goodsId));
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
