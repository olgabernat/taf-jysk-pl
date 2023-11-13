package pl.jysk.taf.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.jysk.taf.po.ChairPage;
import pl.jysk.taf.po.HomePage;

import java.util.List;

public class SearchTest extends BaseTest {
    @Test
    public void testSearch() {
        HomePage homePage = new HomePage();
        homePage.setInputSearchLineLocator("Krzesła");
        homePage.clickButtonSearch();
        ChairPage chairPage = new ChairPage();
        chairPage.clickCenaFilter()
                .setMinCenaFilter(450)
                .setMaxCenaFilter(500)
                .clickCenaFilter()
                .clickCategoryFilter()
                .setCategoryOfChair("Krzesła biurowe")
                .clickCategoryFilter()
                .sortListOfChair()
                .sortListByRate();

        List<String> actualChairsList = chairPage.getSearchResultText();
        String expectedString = "Krzesło biurowe";
        Assertions.assertTrue(actualChairsList.stream().allMatch(item -> item.contains(expectedString)), "Not all items contain the \"Krzesło biurowe\"");

        List<Integer> actualChairPricesList = chairPage.getSearchResultPrice();
        boolean allPricesInRange = true;
        for (int price : actualChairPricesList) {
            if (price < 450 || price > 500) {
                allPricesInRange = false;
            }
        }
        Assertions.assertTrue(allPricesInRange, "Not all prices are in the range 450-500");
    }
}
