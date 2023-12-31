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

    public LoginPage enterEmail(String email) {
        logger.info("Enter email: " + email);
        WebElement emailInputElement = driver.findElement(By.xpath(EMAIL_INPUT_LOCATOR));
        emailInputElement.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        logger.info("Enter email: " + password);
        WebElement passwordInputElement = driver.findElement(By.xpath(PASSWORD_INPUT_LOCATOR));
        passwordInputElement.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        logger.info("Attempting to log in to an account");
        WebElement loginButtonElement = driver.findElement(By.xpath(LOGIN_BUTTON_LOCATOR));
        loginButtonElement.click();
        return this;
    }

    public String getErrorMessage() {
        logger.info("Received a login error");
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ERROR_LOGIN_TEXT_LOCATOR)))
                .getText();
    }

    public String getAlertMessage() {
        logger.info("Received an error for the field");
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ALERT_TEXT_LOCATOR)))
                .getText();
    }
}
