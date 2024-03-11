package pl.piomin.service.kafka.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.piomin.service.kafka.common.Order;
import pl.piomin.service.kafka.consumer.listener.Listener;

@Service
public class Processor {

    private static final Logger LOG = LoggerFactory
            .getLogger(Listener.class);

    public void process(Order order) {
        LOG.info("Processing: {}", order.getId());
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOG.info("Finished: {}", order.getId());
    }

}
