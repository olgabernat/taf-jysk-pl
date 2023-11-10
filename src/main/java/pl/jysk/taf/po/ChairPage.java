package pl.jysk.taf.po;

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

    public ChairPage() {
        this.driver = Singleton.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setCenaFilter(int minPrice, int maxPrice) {
        WebElement selectCenaFilter = driver.findElement(By.xpath(CENA_FILTER_LOCATOR));
        selectCenaFilter.click();

        WebElement minPriceInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(MIN_PRICE_FILTER_LOCATOR)));
        minPriceInput.clear();
        minPriceInput.sendKeys(String.valueOf(minPrice));

        WebElement maxPriceInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(MAX_PRICE_LOCATOR)));
        maxPriceInput.clear();
        maxPriceInput.sendKeys(String.valueOf(maxPrice));
        selectCenaFilter.click();
    }

    public void setCategoryOfChair(String categoryName) {
        WebElement selectCategory = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CATEGORY_LOCATOR)));
        selectCategory.click();

        WebElement selectSpecificCategory = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id = '" + categoryName + "']")));
        selectSpecificCategory.click();

        WebElement sortElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SORT_LOCATOR)));
        sortElement.click();
        WebElement specifySortElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SORT_BY_RATING_LOCATOR)));
        specifySortElement.click();
    }

    public List<String> getSearchResultText() {
        List<String> chairsNames = new ArrayList<>();
        int numberOfElements = 3;

        for (int i = 0; i < numberOfElements; i++) {
            WebElement chairElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CHAIR_TEXT_LOCATOR)));
            chairsNames.add(chairElement.getText());
        }
        return chairsNames;
    }

    public List<Integer> getSearchResultPrice() {
        List<Integer> chairsPrices = new ArrayList<>();
        int numberOfElements = 3;

        for (int i = 0; i < numberOfElements; i++) {
            WebElement chairPriceElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PRICE_LOCATOR)));
            chairsPrices.add(Integer.parseInt(chairPriceElement.getText().replaceAll("[^0-9]", "")));
        }
        return chairsPrices;
    }
}
