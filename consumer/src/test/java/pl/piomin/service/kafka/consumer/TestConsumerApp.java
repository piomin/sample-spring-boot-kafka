package pl.piomin.service.kafka.consumer;

import org.springframework.boot.SpringApplication;

public class TestConsumerApp {

    public static void main(String[] args) {
        SpringApplication.from(ConsumerApp::main)
                .with(KafkaContainerDevMode.class)
                .run(args);
    }

}
