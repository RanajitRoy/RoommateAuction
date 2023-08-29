package com.rmauction.userservice.kafka.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author Ranajit Roy on 8/24/2023
 */
@Component
public class EventDeserializer<T> implements Deserializer<T> {
    private final ObjectMapper mapper;

    public EventDeserializer() {
        mapper = new ObjectMapper();
    }

    @SuppressWarnings("unchecked")
    @Override
    public T deserialize(String s, byte[] bytes) {
        String newString = new String(bytes, StandardCharsets.UTF_8);
        try{
            JSONObject jObj = new JSONObject(newString);
            String enumName = jObj.getString("eventType");
            EventType type = Enum.valueOf(EventType.class, enumName);
            switch (type) {
                case ADD_ROOM -> {
                    return (T) mapper.readValue(newString, AddRoomEvent.class);
                }
                case ADD_USER -> {
                    return (T) mapper.readValue(newString, AddUserEvent.class);
                }
                case DELETE_ROOM -> {
                    return (T) mapper.readValue(newString, DeleteRoomEvent.class);
                }
                case DELETE_USER -> {
                    return (T) mapper.readValue(newString, DeleteUserEvent.class);
                }
            }
        } catch (JsonProcessingException exp) {
            System.out.println(exp);
        }

        return null;
    }
}
