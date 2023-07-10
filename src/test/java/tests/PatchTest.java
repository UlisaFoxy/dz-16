package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class PatchTest extends GenerateToken {
    @Test
    public void updateBooking() {

        JSONObject body = new JSONObject();
        body.put("totalprice", "777");

        Response response = RestAssured.given().log().body()
                .body(body.toString())
                .patch("/booking/{id}", 111);
        response.prettyPrint();
    }

}
