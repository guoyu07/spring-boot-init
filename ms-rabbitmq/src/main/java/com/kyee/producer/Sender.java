package com.kyee.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Sender {

    //AmqpTemplate 接口中定义了一套针对AMQP协议的基础操作
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String message = "spring cloud test message.";
        log.info(message);
        rabbitTemplate.convertAndSend("springCloud", message);
    }
}
