package pl.piomin.service.kafka.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import pl.piomin.service.kafka.common.Order;
import pl.piomin.service.kafka.consumer.service.Processor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class Listener {

    private static final Logger LOG = LoggerFactory
            .getLogger(Listener.class);

    ExecutorService executorService = Executors.newFixedThreadPool(30);

    @KafkaListener(
            id = "transactions",
            topics = "transactions",
            groupId = "a"
    )
    public void listen(@Payload Order order,
                       @Header(KafkaHeaders.OFFSET) Long offset,
                       @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) throws InterruptedException {
        LOG.info("[partition={},offset={}] Starting: {}", partition, offset, order);
        Thread.sleep(10000L);
        LOG.info("[partition={},offset={}] Finished: {}", partition, offset, order);
    }

    @Autowired
    private Processor processor;

    // !!! before testing set the spring.kafka.listener.ack-mode property to ack-mode: MANUAL_IMMEDIATE !!!
    @KafkaListener(
            id = "transactions-async",
            topics = "transactions-async",
            groupId = "a"
    )
    public void listenAsync(@Payload Order order,
                       Acknowledgment acknowledgment,
                       @Header(KafkaHeaders.OFFSET) Long offset,
                       @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        LOG.info("[partition={},offset={}] Starting Async: {}", partition, offset, order);
        executorService.submit(() -> processor.process(order, acknowledgment));
    }
}
