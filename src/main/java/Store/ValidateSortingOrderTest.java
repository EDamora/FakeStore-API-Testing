package Store;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidateSortingOrderTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    @Test
    public void testDescendingSortResults() {
        String sortOrder = "desc"; // Dynamic sort parameter

        // Send GET request with sort parameter
        Response response = RestAssured.given()
                .queryParam("sort", sortOrder)
                .when()
                .get("/products");

        // Log response
        System.out.println("Response: " + response.prettyPrint());

        // Validate status code
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 but got " + response.getStatusCode());

        // Extract product IDs into a list
        var productIds = response.jsonPath().getList("id", Integer.class);

        // Validate the product IDs are sorted in descending order
        for (int i = 0; i < productIds.size() - 1; i++) {
            Assert.assertTrue(
                    productIds.get(i) >= productIds.get(i + 1),
                    "Product IDs are not in descending order at index " + i
            );
        }
    }

    @Test
    public void testAscendingSortResults() {
        String sortOrder = "asc"; // Dynamic sort parameter

        // Send GET request with sort parameter
        Response response = RestAssured.given()
                .queryParam("sort", sortOrder)
                .when()
                .get("/products");

        // Log response
        System.out.println("Response: " + response.prettyPrint());

        // Validate status code
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 but got " + response.getStatusCode());

        // Extract product IDs into a list
        var productIds = response.jsonPath().getList("id", Integer.class);

        // Validate the product IDs are sorted in ascending order
        for (int i = 0; i < productIds.size() - 1; i++) {
            Assert.assertTrue(
                    productIds.get(i) <= productIds.get(i + 1),
                    "Product IDs are not in ascending order at index " + i
            );
        }
    }
}
