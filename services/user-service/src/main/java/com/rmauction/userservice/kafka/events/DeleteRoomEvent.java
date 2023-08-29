package com.rmauction.userservice.kafka.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ranajit Roy on 5/30/2023
 */

@Getter
@Setter
public class DeleteRoomEvent extends Event {
    private long roomId;

    public DeleteRoomEvent() {
        super(EventType.DELETE_ROOM);
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
