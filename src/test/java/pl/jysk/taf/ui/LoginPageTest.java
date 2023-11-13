package pl.jysk.taf.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.jysk.taf.po.HomePage;
import pl.jysk.taf.po.LoginPage;

public class LoginPageTest extends BaseTest{
    @Test
    public void testLoginPageOpened() {
        HomePage homePage = new HomePage();
        homePage.clickButtonLogin();
        LoginPage loginPage = new LoginPage();
        String actualCopywriterText = loginPage.getCopyright();
        String extendsCopywriterText = "Zaloguj się";
        Assertions.assertEquals(extendsCopywriterText, actualCopywriterText);
    }
}
