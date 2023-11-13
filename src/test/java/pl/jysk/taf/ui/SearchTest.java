package pl.jysk.taf.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.jysk.taf.po.SearchPage;
import pl.jysk.taf.po.HomePage;
import pl.jysk.taf.po.LoginPage;

import java.util.List;

public class SearchTest extends BaseTest {
    @Test
    public void testExistSearch() {
        HomePage homePage = new HomePage();
        homePage.setInputSearchLineLocator("Ręcznik FLISBY");
        homePage.clickButtonSearch();
        SearchPage searchPage = new SearchPage();

        List<String> actualList = searchPage.getSearchResultText(2);
        String expectedString = "Ręcznik FLISBY";
        Assertions.assertTrue(actualList.stream().allMatch(item -> item.contains(expectedString)), "Not all items contain the \"Ręcznik FLISBY\"");
    }

    @Test
    public void testNonexistentSearch() {
        HomePage homePage = new HomePage();
        homePage.setInputSearchLineLocator("Люстра");
        String actualError = homePage.getSearchErrorText();
        String expectedError = "Przepraszamy, nie znaleźliśmy żadnych pasujących wyników.";
        Assertions.assertEquals(expectedError, actualError);
    }

    @Test
    public void testNonExistentSearchAfterSubmit() {
        String query = "ЛЮСТРА";
        HomePage homePage = new HomePage();
        homePage.setInputSearchLineLocator(query);
        homePage.clickButtonSearch();
        SearchPage searchPage = new SearchPage();

        String actualError = searchPage.getErrorSearchMessage();
        String expectedError = "PRZEPRASZAMY - NIE MOŻEMY ZNALEŹĆ WYSZUKIWANEJ FRAZY DLA " + query;
        Assertions.assertEquals(expectedError, actualError);
    }
}
