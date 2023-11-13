package pl.jysk.taf.po;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.jysk.taf.singleton.Singleton;

import java.time.Duration;

import static pl.jysk.taf.po.HomePageLocators.*;

public class HomePage {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    public HomePage() {
        this.driver = Singleton.getDriver();
    }

    public void openHomePage() {
        driver.get("https://jysk.pl/");
        logger.info("The site https://jysk.pl/ is opened");
    }

    public void closeCookie() {
        WebElement cookieIfoTextElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(COOKIE_TEXT_LOCATOR)));
        cookieIfoTextElement.click();
        logger.info("Sent consent for cookies.");
    }

    public void closeAdvertisement() {
        WebElement closeAdvertisementButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ADVERTISEMENT_LOCATOR)));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", closeAdvertisementButton);
        logger.info("Advertisement closed.");
    }

    public String getCopyright() {
        logger.info("Copywrite text received");
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(COPYRIGHT_TEXT_LOCATOR)))
                .getText();
    }

    public void setInputSearchLineLocator(String query) {
        WebElement searchInputElement = driver.findElement(By.xpath(INPUT_SEARCH_LINE_LOCATOR));
        searchInputElement.sendKeys(query);
        logger.info("Query sent to the search box:" + query);
    }

    public void clickButtonSearch() {
        WebElement submitWebElement = driver.findElement(By.xpath(SEARCH_BUTTON_LOCATOR));
        submitWebElement.click();
        logger.info("A search is in progress");
    }

    public void clickButtonLogin() {
        WebElement loginWebElement = driver.findElement(By.xpath(LOGIN_BUTTON_LOCATOR));
        loginWebElement.click();
        logger.info("Login page is opened");
    }

    public String getSearchErrorText() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_ERROR_TEXT_LOCATOR)))
                .getText();
    }
}
