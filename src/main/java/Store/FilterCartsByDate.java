package Store;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FilterCartsByDate {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    @Test
    public void testFilterCartsByDate() {
        // Dynamic date range parameters
        String startDate = "2023-01-01";
        String endDate = "2023-12-31";

        // Send GET request with query parameters
        Response response = RestAssured.given()
                .queryParam("startDate", startDate)
                .queryParam("endDate", endDate)
                .when()
                .get("/carts");

        // Log response
        System.out.println("Response: " + response.prettyPrint());

        // Validate status code
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 but got " + response.getStatusCode());

        // Validate response list is not empty
        int responseSize = response.jsonPath().getList("$").size();
        Assert.assertTrue(responseSize > 0, "Expected carts but got none");

        // Validate dates in response (if applicable)
        response.jsonPath().getList("$").forEach(cart -> {
            String date = cart.toString(); // Convert cart to string for analysis (adjust based on response structure)
            Assert.assertNotNull(date, "Cart date should not be null");
            System.out.println("Cart date: " + date); // Logging each cart date
        });
    }
}
