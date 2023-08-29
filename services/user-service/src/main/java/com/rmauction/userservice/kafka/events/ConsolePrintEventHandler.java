package com.rmauction.userservice.kafka.events;

/**
 * @author Ranajit Roy on 8/24/2023
 */
public class ConsolePrintEventHandler implements IEventHandler {

    @Override
    public void setEventArgs(IEventArgs args) {
    }

    @Override
    public void run(Event data) {
        System.out.println(data);
    }
}
