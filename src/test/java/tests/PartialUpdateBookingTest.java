package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PartialUpdateBookingTest extends BasicTest {
    @Test
    public void updateBooking() {
        Response getBookingsResponse = RestAssured.given()
                .cookie(TOKEN, TOKEN_VALUE)
                .get("/booking");
        int bookingId = getBookingsResponse.path("[6].bookingid");

        JSONObject body = new JSONObject();
        body.put("totalprice", "767");

        Response updateBooking = RestAssured.given().log().body()
                .header("Accept", "application/json")
                .body(body.toString())
                .patch("/booking/{id}", bookingId);
        updateBooking.prettyPrint();

        int statusCode = updateBooking.getStatusCode();
        assertEquals(statusCode, 200, "The booking wasn't updated" + statusCode);
    }

}
