package Store;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetAllProductsTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    @Test
    public void testGetAllProducts() {
        // Send GET request to fetch all products
        Response response = RestAssured.given()
                .when()
                .get("/products");

        // Log response
        System.out.println("Response: " + response.prettyPrint());

        // Validate status code
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 but got " + response.getStatusCode());

        // Validate response is not empty
        int productCount = response.jsonPath().getList("$").size();
        Assert.assertTrue(productCount > 0, "Expected product list to be non-empty, but it was empty.");

        // Optional: Print the number of products
        System.out.println("Total products retrieved: " + productCount);
    }
}

