package me.potato.rabbitmq.simpledeadletterconsumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DlqMessageListener {

    private static final String ORIGINAL_SUBSCRIBER_QUEUE_NAME = "messages.messageInputSubs";
    private static final String SUBSCRIBER_DLQ_NAME = ORIGINAL_SUBSCRIBER_QUEUE_NAME + ".dlq";

    @RabbitListener(queues = SUBSCRIBER_DLQ_NAME)
    public void on(Message failed){
        failed.getMessageProperties().getHeaders().keySet().stream().forEach(log::info);
        log.info("Receive DeadLetter : {}", new String(failed.getBody()));
    }


}
