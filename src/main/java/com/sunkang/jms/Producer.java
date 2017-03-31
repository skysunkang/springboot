package com.sunkang.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * Created by changxiang on 2017-03-23.
 * 生产者，发消息的
 */
@Service
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 发送消息
     * @param destination
     * @param message
     */
    public void sendMessage(Destination destination,String message){
        jmsMessagingTemplate.convertAndSend(destination,message);
    }

    /**
     * 负责接受回复
     */
    @JmsListener(destination = "out.queue")
    public void receiveQueue(String text){
        System.out.println("text = [" + text + "]");
    }
}
