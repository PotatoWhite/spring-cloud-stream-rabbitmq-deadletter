package me.potato.rabbitmq.simpledeadletterconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeadletterConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeadletterConsumerApplication.class, args);
    }

}
