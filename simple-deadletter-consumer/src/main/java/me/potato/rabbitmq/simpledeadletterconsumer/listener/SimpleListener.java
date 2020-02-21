package me.potato.rabbitmq.simpledeadletterconsumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@EnableBinding(MessageChannel.class)
@Component
public class SimpleListener {


    @StreamListener(MessageChannel.MESSAGES)
    public void on(@Payload Message message, @Headers MessageHeaders headers) throws Exception {
        headers.keySet().stream().forEach(log::info);
        log.info("{}", message.toString());
        throw new Exception("Go to Dead Letter");
    }

}
