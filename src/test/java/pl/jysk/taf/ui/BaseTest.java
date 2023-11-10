package pl.jysk.taf.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pl.jysk.taf.po.HomePage;
import pl.jysk.taf.singleton.Singleton;

public class BaseTest {
    @BeforeEach
    public void driverSetup() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.closeCookie();
        homePage.closeAdvertisement();
    }

    @AfterEach
    public void driverShutDown() {
        Singleton.quitDriver();
    }
}
