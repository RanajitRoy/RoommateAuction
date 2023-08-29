package com.rmauction.userservice.kafka.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ranajit Roy on 5/25/2023
 */

@Getter
@Setter
public class AddRoomEvent extends Event {
    private long roomId;
    private String roomName;
    private long creatorId;

    public AddRoomEvent() {
        super(EventType.ADD_ROOM);
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
