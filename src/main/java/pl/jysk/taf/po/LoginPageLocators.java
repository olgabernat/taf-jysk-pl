package pl.jysk.taf.po;

public class LoginPageLocators {
    public static final String HEADER_TEXT_LOCATOR = "//p[@class='text-header']";
    public static final String EMAIL_INPUT_LOCATOR = "//input[@name='email']";
    public static final String PASSWORD_INPUT_LOCATOR = "//input[@name='password']";
    public static final String LOGIN_BUTTON_LOCATOR = "//button[@type='submit' and span[text()='Zaloguj się']]";
    public static final String ERROR_TEXT_LOCATOR = "//div[@class='form-errors']";
}
