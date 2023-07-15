package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UpdateBookingTest extends BasicTest {
    @Test
    public void updateBooking() {

        CreateNewBookingBody body = new CreateNewBookingBody().builder()
                .firstname("Josh_New33")
                .lastname("Allen")
                .totalprice(111)
                .depositpaid(true)
                .checkin("2018-01-01")
                .checkout("2019-01-01")
                .additionalneeds("super bowls_the new one")
                .build();

        Response response = RestAssured.given().log().body()
                .header("Accept", "application/json")
                .body(body)
                .put("/booking/{id}", 33);
        response.prettyPrint();
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 200, "The booking №33 wasn't updated" + statusCode);

    }
}
