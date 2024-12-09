package Store;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetSingleProductTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    @Test
    public void testGetSingleProduct() {
        int productId = 1; // Dynamic product ID

        // Send GET request
        Response response = RestAssured.given()
                .when()
                .get("/products/" + productId);

        // Log response
        System.out.println("Response: " + response.prettyPrint());

        // Validate status code
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 but got " + response.getStatusCode());

        // Validate product ID in response
        Assert.assertEquals(response.jsonPath().getInt("id"), productId, "Product ID mismatch in response");

        // Validate additional fields in response
        Assert.assertNotNull(response.jsonPath().getString("title"), "Product title should not be null");
        Assert.assertTrue(response.jsonPath().getFloat("price") > 0, "Product price should be greater than 0");
        Assert.assertNotNull(response.jsonPath().getString("category"), "Product category should not be null");
    }
}
