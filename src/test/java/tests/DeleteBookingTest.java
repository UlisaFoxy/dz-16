package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DeleteBookingTest extends BasicTest {
    @Test
    public void deleteBooking() {
        Response getBookingsResponse = RestAssured.given()
                .cookie(TOKEN, TOKEN_VALUE)
                .get("/booking");

        int bookingId = getBookingsResponse.path("[0].bookingid");

        Response deleteBooking = RestAssured.given().log().body()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .cookie(TOKEN, TOKEN_VALUE)
                .delete("/booking/{bookingId}", bookingId);
        deleteBooking.prettyPrint();
        int statusCode = deleteBooking.getStatusCode();
        assertEquals(statusCode, 201, "The booking wasn't deleted" + statusCode);
    }

}
