package pl.jysk.taf.po;

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

    public HomePage() {
        this.driver = Singleton.getDriver();
    }

    public void openHomePage() {
        driver.get("https://jysk.pl/");
    }

    public void closeCookie() {
        WebElement cookieIfoTextElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(COOKIE_TEXT_LOCATOR)));
        cookieIfoTextElement.click();
    }

    public void closeAdvertisement() {
        WebElement closeAdvertisementButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ADVERTISEMENT_LOCATOR)));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", closeAdvertisementButton);
    }

    public String getCopyright() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(COPYRIGHT_TEXT_LOCATOR)))
                .getText();
    }

    public void setInputSearchLineLocator(String query) {
        WebElement searchInputElement = driver.findElement(By.xpath(INPUT_SEARCH_LINE_LOCATOR));
        searchInputElement.sendKeys(query);
    }

    public void clickButtonSearch() {
        WebElement submitWebElement = driver.findElement(By.xpath(BUTTON_SEARCH_LOCATOR));
        submitWebElement.click();
    }
}
