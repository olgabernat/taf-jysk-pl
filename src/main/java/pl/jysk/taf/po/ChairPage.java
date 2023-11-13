package pl.jysk.taf.po;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.jysk.taf.singleton.Singleton;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static pl.jysk.taf.po.ChairPageLocators.*;


public class ChairPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger();

    public ChairPage() {
        this.driver = Singleton.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public ChairPage clickPriceFilter() {
        WebElement selectPriceFilter = driver.findElement(By.xpath(PRICE_FILTER_LOCATOR));
        selectPriceFilter.click();
        logger.info("A filter by price is applied.");
        return this;
    }

    public ChairPage setMinPriceFilter(int minPrice) {
        WebElement minPriceInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MIN_PRICE_LOCATOR)));
        minPriceInput.click();
        minPriceInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        minPriceInput.sendKeys(String.valueOf(minPrice));
        logger.info("Min price - " + minPrice);
        return this;
    }

    public ChairPage setMaxCenaFilter(int maxPrice) {
        WebElement maxPriceInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(MAX_PRICE_LOCATOR)));
        maxPriceInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        maxPriceInput.sendKeys(String.valueOf(maxPrice));
        logger.info("Maximum price - " + maxPrice);
        return this;
    }

    public ChairPage clickCategoryFilter() {
        WebElement selectCategory = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CATEGORY_LOCATOR)));
        selectCategory.click();
        logger.info("A filter by category is applied.");
        return this;
    }

    public ChairPage setCategoryOfChair(String categoryName) {
        WebElement selectSpecificCategory = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id = '" + categoryName + "']")));
        selectSpecificCategory.click();
        driver.navigate().refresh();
        logger.info("Selected category - " + categoryName);
        return this;
    }

    public ChairPage sortListOfChair() {
        WebElement sortElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SORT_LOCATOR)));
        sortElement.click();
        return this;
    }

    public ChairPage sortListByRate() {
        WebElement specifySortElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SORT_BY_RATING_LOCATOR)));
        specifySortElement.click();
        logger.info("List sorted by rating");
        return this;
    }

    public List<String> getSearchResultText() {
        List<String> chairsNames = new ArrayList<>();
        logger.info("A list with search results has been created");
        int numberOfElements = 3;

        for (int i = 0; i < numberOfElements; i++) {
            WebElement chairElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CHAIR_TEXT_LOCATOR)));
            chairsNames.add(chairElement.getText());
        }
        return chairsNames;
    }

    public List<Integer> getSearchResultPrice() {
        List<Integer> chairsPrices = new ArrayList<>();
        logger.info("Created list with prices of goods");
        int numberOfElements = 3;

        for (int i = 0; i < numberOfElements; i++) {
            WebElement chairPriceElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PRICE_LOCATOR)));
            chairsPrices.add(Integer.parseInt(chairPriceElement.getText().replaceAll("[^0-9]", "")));
        }
        return chairsPrices;
    }
}
