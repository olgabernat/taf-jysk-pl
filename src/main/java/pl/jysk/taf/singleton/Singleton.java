package pl.jysk.taf.singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Singleton {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    private Singleton() {
    }

    public static WebDriver getDriver() {
        logger.info("Perform driver");

        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        logger.info("Driver is closed");
    }
}
