package com.rmauction.userservice.kafka.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

/**
 * @author Ranajit Roy on 8/23/2023
 */

@Getter
@Setter
public class DeleteUserEvent extends Event{
    private long userId;

    public DeleteUserEvent() {
        super(EventType.DELETE_USER);
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.writeValueAsString(this);
        }
        catch(JsonProcessingException exp) {
            return super.toString();
        }
    }
}
