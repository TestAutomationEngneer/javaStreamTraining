package jacksonOperations.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Getter
public class ConfigurationReader {
    private static final String FILE_PATH = "src/test/resources/configuration.yml";

    public Environment readYamlFile() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        try {
            Config config = mapper.readValue(new File(FILE_PATH), Config.class);
            Optional<Environment> first = config.getEnvironments().values().stream()
                    .filter(Environment::isActive)
                    .findFirst();
            if (!first.isPresent()) {
                log.error("Error while parsing for active environments.");
                throw new InvalidConfigException("There can be only one active environment");
            }
            return first.get();

        } catch (IOException | InvalidConfigException e) {
            log.error("Error reading YAML file: {}", e.getMessage(), e);
            throw new RuntimeException("Error reading YAML file: " + e.getMessage());
        }
    }
}

