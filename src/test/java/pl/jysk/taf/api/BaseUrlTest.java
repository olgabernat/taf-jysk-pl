package pl.jysk.taf.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class BaseUrlTest {
    @DisplayName("Check the base URL")
    @Test
    public void testBaseUrl() {
        when().get("https://jysk.pl/").then().statusCode(200);
    }
}
