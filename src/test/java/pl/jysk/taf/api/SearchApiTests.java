package pl.jysk.taf.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class SearchApiTests {
    private static final String BASE_URL = "https://jysk.pl/search";

    @DisplayName("Search for a specific product")
    @Test
    public void testSearchForProduct() {
        String searchItem = "Krzesła";
        Response response = RestAssured
                .given()
                .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36")
                .queryParam("query", searchItem)
                .when().get(BASE_URL);
        String responseBody = response.getBody().asPrettyString();
        Assertions.assertTrue(responseBody.contains(searchItem), searchItem + " not found");
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @DisplayName("Search with an empty query")
    @Test
    public void testSearchEmptyQuery() {
        Response response = RestAssured
                .given()
                .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36")
                .queryParam("query", "")
                .when().get(BASE_URL);
        String responseBody = response.getBody().asPrettyString();
        Assertions.assertTrue(responseBody.contains("Wszystkie kategorie"));
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @DisplayName("Search with a non-existent product")
    @Test
    public void testSearchWithNonExistentProduct() {
        String searchItem = "test123";
        String expectedResponse = "Niestety, nie ma sklepów z zestawem artykułów";
        Response response = RestAssured
                .given()
                .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36")
                .queryParam("query", searchItem)
                .when().get(BASE_URL);
        String responseBody = response.getBody().asPrettyString();
        Assertions.assertTrue(responseBody.contains(expectedResponse));
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
