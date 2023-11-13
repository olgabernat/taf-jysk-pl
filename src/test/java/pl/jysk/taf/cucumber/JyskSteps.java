package pl.jysk.taf.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pl.jysk.taf.po.HomePage;

public class JyskSteps {
    public static HomePage homePage;

    @When("User is on the HomePage")
    public static void userOpenHomePage() {
        homePage = new HomePage();
        homePage.openHomePage();
        homePage.closeCookie();
        homePage.closeAdvertisement();
    }

    @Then("User received copywriter text")
    public static void userReceivedCopywriterText() {
        HomePage homePage = new HomePage();
        String actualCopywriterText = homePage.getCopyright();
        String extendsCopywriterText = "NIP 586-20-16-763 Sąd Rejonowy Gdańsk-Północ VII Wydz. Gospodarczy KRS 0000036908 ";
        Assertions.assertEquals(extendsCopywriterText, actualCopywriterText);
    }
}
