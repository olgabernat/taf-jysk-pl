package pl.jysk.taf.po;

public class HomePageLocators {
    public static final String COOKIE_TEXT_LOCATOR = "//button[@onclick = 'CookieInformation.submitAllCategories();']";
    public static final String COPYRIGHT_TEXT_LOCATOR = "//div[@class='company-details-text']/p/span[contains(text(), 'NIP 586-20-16-763 Sąd Rejonowy Gdańsk-Północ VII Wydz. Gospodarczy KRS 0000036908')]";
    public static final String INPUT_SEARCH_LINE_LOCATOR = "//input[@placeholder='Szukaj produktu lub kategorii…']";
    public static final String SEARCH_BUTTON_LOCATOR = "//span[@class = 'search-input-text']";
    public static final String ADVERTISEMENT_LOCATOR = "//div[@class='close-x']";
    public static final String LOGIN_BUTTON_LOCATOR = "//span[@class='icon-text text-uppercase py-1 d-block' and text()='Zaloguj się']";
    public static final String SEARCH_ERROR_TEXT_LOCATOR = "//div[@role = 'alert']";
}
