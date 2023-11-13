package pl.jysk.taf.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.jysk.taf.po.SearchPage;
import pl.jysk.taf.po.HomePage;

import java.util.List;

public class SearchFiltersTest extends BaseTest{
    @Test
    public void testSearchWithFilters() {
        HomePage homePage = new HomePage();
        homePage.setInputSearchLineLocator("Krzesła");
        homePage.clickButtonSearch();
        SearchPage searchPage = new SearchPage();
        searchPage.clickPriceFilter()
                .setMinPriceFilter(450)
                .setMaxCenaFilter(500)
                .clickPriceFilter()
                .clickCategoryFilter()
                .setCategoryOfChair("Krzesła biurowe")
                .clickCategoryFilter()
                .sortListOfChair()
                .sortListByRate();

        List<String> actualChairsList = searchPage.getSearchResultText(3);
        String expectedString = "Krzesło biurowe";
        Assertions.assertTrue(actualChairsList.stream().allMatch(item -> item.contains(expectedString)), "Not all items contain the \"Krzesło biurowe\"");

        List<Integer> actualChairPricesList = searchPage.getSearchResultPrice();
        boolean allPricesInRange = true;
        for (int price : actualChairPricesList) {
            if (price < 450 || price > 500) {
                allPricesInRange = false;
            }
        }
        Assertions.assertTrue(allPricesInRange, "Not all prices are in the range 450-500");
    }
}
