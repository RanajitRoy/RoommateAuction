package com.rmauction.roomservice.kafka;

import com.rmauction.kafkainterface.events.Event;
import com.rmauction.kafkainterface.events.IEventHandler;
import lombok.Setter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author Ranajit Roy on 8/23/2023
 */

@Service
public class ConsumerService {
    @Setter
    private IEventHandler roomHandler;
    @Setter
    private IEventHandler userHandler;

    @KafkaListener(topics = KafkaTopics.ROOM, groupId = "group1", containerFactory = "concKafkaListenerFactory")
    void roomListener(Event data) {
        roomHandler.run(data);
    }

    @KafkaListener(topics = KafkaTopics.USER, groupId = "group1", containerFactory = "concKafkaListenerFactory")
    void userListener(Event data) {
        userHandler.run(data);
    }
}
