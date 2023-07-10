package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;

public class GenerateToken {
    public static String TOKEN_VALUE;
    public static final String TOKEN = "token";

    @BeforeClass
    public void generateToken() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();

        JSONObject body = new JSONObject();
        body.put("password", "password123");
        body.put("username", "admin");

        Response response = RestAssured.given()
                .body(body.toString())
                .post("/auth");
        response.prettyPrint();
        TOKEN_VALUE = response.then().extract().jsonPath().get(TOKEN);
    }
}
