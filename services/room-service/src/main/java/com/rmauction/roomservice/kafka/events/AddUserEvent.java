package com.rmauction.roomservice.kafka.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ranajit Roy on 8/23/2023
 */

@Getter
@Setter
public class AddUserEvent extends Event{
    private long userId;

    private String userName;

    public AddUserEvent() {
        super(EventType.ADD_USER);
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
