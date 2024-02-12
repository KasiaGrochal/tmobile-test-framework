package configuration.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

@Slf4j
public class DriverFactory {

    public WebDriver getDriver(Browser browser) {
        WebDriver webDriver;
        switch (browser) {
            case CHROME:
                webDriver = getChrome();
                break;
            case FIREFOX:
                webDriver = getFirefox();
                break;
            default:
                return getChrome();
        }
        return webDriver;

    }

    private WebDriver getFirefox() {
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        optionsFirefox.addArguments("start-maximized");
        log.info("Initializing Firefox as a running browser");
        return new FirefoxDriver(optionsFirefox);
    }

    private WebDriver getChrome() {
        ChromeOptions optionsChrome = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        optionsChrome.addArguments("start-maximized");
        optionsChrome.addArguments("--remote-allow-origins=*");
        log.info("Initializing Chrome as a running browser");
        return new ChromeDriver(optionsChrome);
    }
}
