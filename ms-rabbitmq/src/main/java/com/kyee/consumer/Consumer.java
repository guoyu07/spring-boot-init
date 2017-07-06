package com.kyee.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//注解RabbitListener定义该类对‘springCloud’队列的监听
@RabbitListener(queues = "springCloud")
@Component
@Slf4j
public class Consumer {

    //注解RabbitHandler指定对消息的处理方法
    @RabbitHandler
    public void consume(String message){
        log.info(message);
    }
}
