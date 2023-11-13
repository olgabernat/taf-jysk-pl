package pl.jysk.taf.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest {
    private static final String BASE_URL = "https://jysk.pl/wss/json/v2/data/customer/session";

    @DisplayName("Check login with empty data")
    @Test
    public void testPostEmptyEmailAndPassword() {
        String body = "{\n" +
                "    \"email\": \"\",\n" +
                "    \"password\": \"\"\n" +
                "}";
        String expectedError1 = "Invalid credentials: Either email, mobile, or username must be provided";
        String expectedError2 = "Please enter a valid e-mail";

        given().header("Content-Type", "application/json").body(body).
                when().post(BASE_URL)
                .then().assertThat().statusCode(400)
                .body("translationDefaultText", equalTo("Invalid input"))
                .body("errorDetails.flatten().translationDefaultText",
                        containsInAnyOrder(expectedError1, expectedError2));
    }

    @DisplayName("Check login with empty password")
    @Test
    public void testPostAnyEmailEmptyPassword() {
        String body = "{\n" +
                "    \"email\": \"test@test.com\",\n" +
                "    \"password\": \"\"\n" +
                "}";

        given().header("Content-Type", "application/json").body(body).
                when().post(BASE_URL)
                .then().assertThat().statusCode(401)
                .body("translationDefaultText", equalTo("Insufficient permissions"))
                .body("errorDetails.flatten().translationDefaultText", containsInAnyOrder("Login of ${username} failed"));
    }

    @DisplayName("Check login with empty email")
    @Test
    public void testPostEmptyEmailAnyPassword() {
        String body = "{\n" +
                "    \"email\": \"\",\n" +
                "    \"password\": \"123456aA\"\n" +
                "}";
        String expectedError1 = "Invalid credentials: Either email, mobile, or username must be provided";
        String expectedError2 = "Please enter a valid e-mail";

        given().header("Content-Type", "application/json").body(body).
                when().post(BASE_URL)
                .then().assertThat().statusCode(400)
                .body("translationDefaultText", equalTo("Invalid input"))
                .body("errorDetails.flatten().translationDefaultText", containsInAnyOrder(expectedError1, expectedError2));
    }

    @DisplayName("Check login by unregistered user")
    @Test
    public void testPostNonExistingCredentials() {
        String body = "{\n" +
                "    \"email\": \"test@test.com\",\n" +
                "    \"password\": \"123456aA\"\n" +
                "}";

        given().header("Content-Type", "application/json").body(body).
                when().post(BASE_URL)
                .then().assertThat().statusCode(401)
                .body("translationDefaultText",
                        equalTo("Insufficient permissions"))
                .body("errorDetails.flatten().translationDefaultText", hasItem("Login of ${username} failed"));
    }

    @DisplayName("Check login without password")
    @Test
    public void testPostEnterOnlyEmail() {
        String body = "{\n" +
                "    \"email\": \"test@test.com\"\n" +
                "}";
        given().header("Content-Type", "application/json").body(body).
                when().post(BASE_URL)
                .then().assertThat().statusCode(400)
                .body("translationDefaultText",
                        equalTo("Invalid input"))
                .body("errorDetails.flatten().translationDefaultText", hasItem("Please enter a password"));
    }

    @DisplayName("Check login without email")
    @Test
    public void testPostEnterOnlyPassword() {
        String body = "{\n" +
                "    \"password\": \"123456aA\"\n" +
                "}";
        given().header("Content-Type", "application/json").body(body).
                when().post(BASE_URL)
                .then().assertThat().statusCode(400)
                .body("translationDefaultText",
                        equalTo("Invalid input"))
                .body("errorDetails.flatten().translationDefaultText", hasItem("Please enter your e-mail"));
    }
}
