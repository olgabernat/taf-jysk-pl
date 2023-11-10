package pl.jysk.taf.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pl.jysk.taf.po.HomePage;

public class JyskSteps {
    public static HomePage homePage;
    private static String query1;

    @Given("User is on the HomePage")
    public static void userOpenHomePage() {
        homePage = new HomePage();
        homePage.openHomePage();
        homePage.closeCookie();
    }

    @When("User enters {string} and click search button")
    public static void userEnterSearchQueryAndClickSearch(String query) {
        query1 = query;
        homePage.setInputSearchLineLocator(query1);
        homePage.clickButtonSearch();
    }

    @Then("Search result equals to expected result")
    public static void userGetResult() {
        Assertions.assertEquals("а","g");
    }
// дописать список
}
