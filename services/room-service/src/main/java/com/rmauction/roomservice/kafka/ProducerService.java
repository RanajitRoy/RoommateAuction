package com.rmauction.roomservice.kafka;

import com.rmauction.kafkainterface.events.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Ranajit Roy on 8/22/2023
 */

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, Event> kafkaTemplate;

    public void sendEvent(String topic, Event event){
        kafkaTemplate.send(topic, topic, event);
    }
}
