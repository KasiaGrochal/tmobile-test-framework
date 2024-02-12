package configuration.models;

import configuration.browser.Browser;
import lombok.Data;

@Data
public class Config {

    private EnvironmentProperties environmentProperties;
    private Browser browser;


}
