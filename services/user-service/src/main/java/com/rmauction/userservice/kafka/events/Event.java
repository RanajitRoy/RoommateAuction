package com.rmauction.userservice.kafka.events;

import lombok.*;

/**
 * @author Ranajit Roy on 5/25/2023
 */


@Getter
@Setter
@AllArgsConstructor
public abstract class Event {
    private EventType eventType;
}
