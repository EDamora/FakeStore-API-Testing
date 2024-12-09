package Store;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddNewCartTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    private String generateRequestBody() {
        return "{\n" +
                "  \"userId\": 1,\n" +
                "  \"products\": [\n" +
                "    {\"productId\": 1, \"quantity\": 2},\n" +
                "    {\"productId\": 2, \"quantity\": 1}\n" +
                "  ]\n" +
                "}";
    }

    @Test
    public void testAddNewCart() {
        // Generate request body dynamically
        String requestBody = generateRequestBody();

        // Send POST request
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/carts");

        // Validate status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Expected status code 200 but got " + statusCode);

        // Validate response body
        Assert.assertNotNull(response.jsonPath().get("id"), "Cart ID should not be null");
        Assert.assertEquals(response.jsonPath().getInt("userId"), 1, "User ID mismatch");
        Assert.assertTrue(response.jsonPath().getList("products").size() > 0, "Products list should not be empty");

        // Log response
        System.out.println("Response: " + response.prettyPrint());
    }
}
