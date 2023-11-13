package pl.jysk.taf.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.jysk.taf.po.HomePage;

public class HomePageTest extends BaseTest {
    @Test
    public void testHomePageOpened() {
        HomePage homePage = new HomePage();
        String actualCopywriterText = homePage.getCopyright();
        String extendsCopywriterText = "NIP 586-20-16-763 Sąd Rejonowy Gdańsk-Północ VII Wydz. Gospodarczy KRS 0000036908 ";
        Assertions.assertEquals(extendsCopywriterText, actualCopywriterText);
    }
}
