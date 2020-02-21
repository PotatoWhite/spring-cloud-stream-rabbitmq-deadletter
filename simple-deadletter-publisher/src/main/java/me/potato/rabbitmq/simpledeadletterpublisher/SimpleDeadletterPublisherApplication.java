package me.potato.rabbitmq.simpledeadletterpublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleDeadletterPublisherApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleDeadletterPublisherApplication.class, args);
    }

}
