package pl.jysk.taf.po;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.jysk.taf.singleton.Singleton;

import java.time.Duration;

import static pl.jysk.taf.po.HomePageLocators.INPUT_SEARCH_LINE_LOCATOR;
import static pl.jysk.taf.po.LoginPageLocators.*;

public class LoginPage {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    public LoginPage() {
        this.driver = Singleton.getDriver();
    }

    public String getCopyright() {
        logger.info("Copywrite text on the Login page received");
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(HEADER_TEXT_LOCATOR)))
                .getText();
    }

    public LoginPage enterEmail (String email) {
        WebElement emailInputElement = driver.findElement(By.xpath(EMAIL_INPUT_LOCATOR));
        emailInputElement.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword (String password) {
        WebElement passwordInputElement = driver.findElement(By.xpath(PASSWORD_INPUT_LOCATOR));
        passwordInputElement.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton () {
        WebElement loginButtonElement = driver.findElement(By.xpath(LOGIN_BUTTON_LOCATOR));
        loginButtonElement.click();
        return this;
    }

    public String getErrorMessage () {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ERROR_TEXT_LOCATOR)))
                .getText();
    }

    public String getAlertMessage () {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ALERT_TEXT_LOCATOR)))
                .getText();
    }
}
