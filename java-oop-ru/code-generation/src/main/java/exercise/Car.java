package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    private int id;
    private String brand;
    private String model;
    private String color;
    private User owner;

    // BEGIN
    public String serialize() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }

    public static Car unserialize(String json) throws IOException {
        return new ObjectMapper().readValue(json, Car.class);
    }
    // END
}
