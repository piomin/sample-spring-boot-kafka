package pl.piomin.service.kafka.consumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.kafka.KafkaContainer;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Testcontainers
class ConsumerIntegrationTest {

    @Container
    @ServiceConnection
    static KafkaContainer kafka = new KafkaContainer("apache/kafka-native:4.2.0");

    @Test
    void contextLoads() {
        assertTrue(true, "Application context should load successfully");
    }

    @Test
    void kafkaConnectionTest() {
        assertTrue(kafka.isRunning(), "Kafka container should be running");
        assertTrue(kafka.getBootstrapServers() != null && !kafka.getBootstrapServers().isEmpty(), 
                  "Kafka bootstrap servers should be available");
    }
}
