package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DeleteTest extends GenerateToken {
    @Test
    public void deleteBooking() {
        Response deleteBooking = RestAssured.given().log().body()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .cookie(TOKEN, TOKEN_VALUE)
                .delete("/booking/{bookingId}", 1);
        deleteBooking.prettyPrint();
    }

}
