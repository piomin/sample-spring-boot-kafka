package pl.piomin.services.kafka.producer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.piomin.service.kafka.common.Order;
import pl.piomin.services.kafka.producer.api.InputParameters;

import java.util.concurrent.CompletableFuture;

@RestController
public class TransactionsController {

    private static final Logger LOG = LoggerFactory
            .getLogger(TransactionsController.class);

    long id = 1;
    long groupId = 1;

    @Autowired
    KafkaTemplate<Long, Order> kafkaTemplate;

    @PostMapping("/transactions")
    public void generateAndSendMessages(@RequestBody InputParameters inputParameters) {
        for (long i = 0; i < inputParameters.getNumberOfMessages(); i++) {
            Order o = new Order(id++, i+1, i+2, 1000, "NEW", groupId);
            CompletableFuture<SendResult<Long, Order>> result =
                    kafkaTemplate.send("transactions-async", o.getId(), o);
            result.whenComplete((sr, ex) ->
                    LOG.info("Sent({}): {}", sr.getProducerRecord().key(), sr.getProducerRecord().value()));
        }
        groupId++;
    }

}
