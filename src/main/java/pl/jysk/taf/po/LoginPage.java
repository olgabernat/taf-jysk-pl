package pl.jysk.taf.po;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.jysk.taf.singleton.Singleton;

import java.time.Duration;

import static pl.jysk.taf.po.LoginPageLocators.HEADER_TEXT_LODCATOR;

public class LoginPage {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    public LoginPage() {
        this.driver = Singleton.getDriver();
    }

    public String getCopyright() {
        logger.info("Copywrite text on the Login page received");
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(HEADER_TEXT_LODCATOR)))
                .getText();
    }
}
