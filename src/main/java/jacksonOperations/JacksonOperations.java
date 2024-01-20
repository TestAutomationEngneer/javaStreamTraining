package jacksonOperations;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JacksonOperations {

    ObjectMapper objectMapper = new ObjectMapper();


    public Actor readActor() throws IOException {
        Actor actor = objectMapper.readValue(getClass().getResourceAsStream("/data/actor.json"), Actor.class);
        return actor;
    }

}
