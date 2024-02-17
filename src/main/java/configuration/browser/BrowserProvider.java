package configuration.browser;

import configuration.models.Config;
import lombok.extern.slf4j.Slf4j;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

@Slf4j

public class BrowserProvider {
    private static final Logger logger = LoggerFactory.getLogger(BrowserProvider.class);

    public static Browser getBrowser(Config config) {
        return getBrowserValueFromPom().isEmpty() ? getBrowserFromConfigFile(config) : getBrowserSetInPOM();
    }

    private static String getBrowserValueFromPom(){
        return System.getProperty("Browser_Value");
    }

    private static Browser getBrowserFromConfigFile(Config config){
        Browser browser = Browser.CHROME;
        try{
            browser = config.getBrowser();
        }catch (NullPointerException e){
            logger.info("No driver was specified. Running test on default browser: {}",browser);
            return browser;
        }
        logger.info("Driver specified in config.yaml: {}",browser);
        return browser;
    }

    private static Browser getBrowserSetInPOM() {
        String browserName= getBrowserValueFromPom();
        switch (browserName) {
            case "chrome":
                logger.info("Browser set in POM: {}",browserName);
                return Browser.CHROME;
            case "firefox":
                logger.info("Browser set in POM: {}",browserName);
                return Browser.FIREFOX;
            default:
                logger.info("Found browser set in POM: '{}' -invalid name for browser",browserName);
                throw  new NoSuchElementException("Incorrect Name of the browser");
        }
    }
}
