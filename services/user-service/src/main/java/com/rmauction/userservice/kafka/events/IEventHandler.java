package com.rmauction.userservice.kafka.events;

/**
 * @author Ranajit Roy on 8/24/2023
 */
public interface IEventHandler {
    void setEventArgs(IEventArgs args);

    void run(Event data);
}
