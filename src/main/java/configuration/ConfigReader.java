package configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import configuration.models.Config;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Data
@Slf4j
public class ConfigReader {

    private Config config;

    public ConfigReader() {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.findAndRegisterModules();
            config = mapper.readValue(new File("src/main/resources/config.yml"), Config.class);
            log.info("Config was loaded from config.yml");
        } catch (IOException e) {
            log.error("Exception caught while reading config.yaml");
        }
    }
}
