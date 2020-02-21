package me.potato.rabbitmq.simpledeadletterpublisher.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@EnableBinding(Source.class)
public class SimpleController {
    private Source source;

    public SimpleController(Source source) {
        this.source = source;
    }

    @GetMapping("/api/pub")
    public boolean publish() {
        return source.output().send(MessageBuilder.withPayload(
                new Message("Hello Rabbit")
        ).build());
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @RequiredArgsConstructor
    class Message {
        @NonNull
        private String messages;
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        private LocalDateTime date = LocalDateTime.now();
    }
}
