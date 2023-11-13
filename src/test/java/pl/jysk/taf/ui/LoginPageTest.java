package pl.jysk.taf.ui;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.jysk.taf.po.HomePage;
import pl.jysk.taf.po.LoginPage;
import pl.jysk.taf.util.Utils;

public class LoginPageTest extends BaseTest {
    @Test
    public void testLoginPageOpened() {
        HomePage homePage = new HomePage();
        homePage.clickButtonLogin();
        LoginPage loginPage = new LoginPage();

        String actualCopywriterText = loginPage.getCopyright();
        String expectedCopywriterText = "Zaloguj się";
        Assertions.assertEquals(expectedCopywriterText, actualCopywriterText);
    }

    @Test
    public void testLoginNotExistUser() {
        HomePage homePage = new HomePage();
        homePage.clickButtonLogin();
        LoginPage loginPage = new LoginPage();
        String randomEmail = Utils.generateRandomEmail();
        loginPage.enterEmail(randomEmail)
                .enterPassword(Utils.generatePassword())
                .clickLoginButton();

        String actualError = loginPage.getErrorMessage();
        String expectedError = "Login of " + randomEmail + " failed";
        Assertions.assertEquals(expectedError, actualError);
    }

    @Test
    public void testLoginEmptyPassword() {
        HomePage homePage = new HomePage();
        homePage.clickButtonLogin();
        LoginPage loginPage = new LoginPage();
        Faker faker = new Faker();
        loginPage.enterEmail(faker.internet().emailAddress())
                .enterPassword("")
                .clickLoginButton();

        String actualError = loginPage.getAlertMessage();
        String expectedError = "To pole jest wymagane.";
        Assertions.assertEquals(expectedError, actualError);
    }

    @Test
    public void testLoginEmptyEmail() {
        HomePage homePage = new HomePage();
        homePage.clickButtonLogin();
        LoginPage loginPage = new LoginPage();
        Faker faker = new Faker();
        loginPage.enterEmail("")
                .enterPassword(faker.internet().password())
                .clickLoginButton();

        String actualError = loginPage.getAlertMessage();
        String expectedError = "To pole jest wymagane.";
        Assertions.assertEquals(expectedError, actualError);
    }

    @Test
    public void testLoginInvalidEmail() {
        HomePage homePage = new HomePage();
        homePage.clickButtonLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("qwer")
                .enterPassword(Utils.generatePassword())
                .clickLoginButton();

        String actualError = loginPage.getAlertMessage();
        String expectedError = "Wprowadź poprawny adres e-mail.";
        Assertions.assertEquals(expectedError, actualError);
    }
}
