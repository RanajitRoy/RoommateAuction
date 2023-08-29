package com.rmauction.roomservice.kafka.events;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Ranajit Roy on 8/24/2023
 */

public enum EventType {
    ADD_ROOM,
    DELETE_ROOM,
    ADD_USER,
    DELETE_USER;
}
