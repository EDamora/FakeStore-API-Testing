package Store;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetUserCartTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    @Test
    public void testGetUserCart() {
        int userId = 2; // Dynamic parameter for userId

        // Send GET request
        Response response = RestAssured.given()
                .when()
                .get("/carts/user/" + userId);

        // Log response
        System.out.println("Response: " + response.prettyPrint());

        // Validate status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Expected status code 200 but got " + statusCode);

        // Validate userId in response
        int responseUserId = response.jsonPath().getInt("[0].userId");
        Assert.assertEquals(responseUserId, userId, "User ID mismatch in response");

        // Validate carts are not empty
        Assert.assertTrue(response.jsonPath().getList("[0].products").size() > 0, "Products list should not be empty");
    }
}

