package me.potato.rabbitmq.simpledeadletterconsumer.listener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Message {
    @NonNull
    private String messages;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime date;
}