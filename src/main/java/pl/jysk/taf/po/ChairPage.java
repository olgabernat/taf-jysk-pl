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

    public void setCenaFilter(int minPrice, int maxPrice) {
        WebElement selectCenaFilter = driver.findElement(By.xpath(CENA_FILTER_LOCATOR));
        selectCenaFilter.click();
        logger.info("A filter by price is applied.");

        WebElement minPriceInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(MIN_PRICE_FILTER_LOCATOR)));
        minPriceInput.clear();
        minPriceInput.sendKeys(String.valueOf(minPrice));
        logger.info("Min price - " + minPrice);

        WebElement maxPriceInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(MAX_PRICE_LOCATOR)));
        maxPriceInput.clear();
        maxPriceInput.sendKeys(String.valueOf(maxPrice));
        selectCenaFilter.click();
        logger.info("Maximum price - " + maxPrice);
    }

    public void setCategoryOfChair(String categoryName) {
        WebElement selectCategory = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CATEGORY_LOCATOR)));
        selectCategory.click();
        logger.info("A filter by category is applied.");

        WebElement selectSpecificCategory = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id = '" + categoryName + "']")));
        selectSpecificCategory.click();
        logger.info("Selected category - " + categoryName);

        WebElement sortElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SORT_LOCATOR)));
        sortElement.click();
        WebElement specifySortElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SORT_BY_RATING_LOCATOR)));
        specifySortElement.click();
        logger.info("List sorted by rating");
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
