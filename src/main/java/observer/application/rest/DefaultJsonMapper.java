package observer.application.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DefaultJsonMapper implements JsonMapper {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Override
    public <R> R toObject(String content, Class<R> valueType) {
        try {
            return OBJECT_MAPPER.readValue(content, valueType);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not deserialize object", e);
        }
    }

    @Override
    public String toJson(Object value) {
        try {
            return OBJECT_MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Could not serialize object", e);
        }
    }
}
