package com.lamansys.ws;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ApiTest {

    private Response response;

    @Test
    public void testDogApi() {
        response = RestAssured.get("https://dog.ceo/api/breeds/image/random");
        Assert.assertEquals(200, response.getStatusCode());
        JsonPath jsonPath = response.jsonPath();
        String statusResponseBody = jsonPath.getString("status");
        Assert.assertEquals("success", statusResponseBody);
    }

    @Test
    public void testFakeStore() {
        response = RestAssured.get("https://fakestoreapi.com/products/5");
        Assert.assertEquals(200, response.getStatusCode());
        JsonPath jsonPath = response.jsonPath();
        String categoryResponseBody = jsonPath.getString("category");
        Assert.assertEquals("jewelery", categoryResponseBody);
    }

}
