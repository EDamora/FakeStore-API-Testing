package Store;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidateProductLimitTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    @Test
    public void testLimitResultsToThree() {
        int limit = 3; // Limit set to 3

        // Send GET request with limit query parameter
        Response response = RestAssured.given()
                .queryParam("limit", limit)
                .when()
                .get("/products");

        // Log response
        System.out.println("Response: " + response.prettyPrint());

        // Validate status code
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 but got " + response.getStatusCode());

        // Validate response size matches limit
        int actualSize = response.jsonPath().getList("$").size();
        Assert.assertEquals(actualSize, limit, "Response size does not match the limit of " + limit);
    }
}
