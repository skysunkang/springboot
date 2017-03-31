package com.sunkang.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Created by changxiang on 2017-03-23.
 * 消费者
 */
@Component
public class Consumer {
    @JmsListener(destination = "mytest.queue")
    @SendTo("out.queue")//给回复
    private String receiveQueue(String text) {
        System.out.println("Consumer收到的报文为:"+text);
        return "sunkang ,我已经收到";
    }
}
