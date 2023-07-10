package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PutTest extends GenerateToken{
    @Test
    public void updateBooking() {

        CreateNewBookingBody body = new CreateNewBookingBody().builder()
                .firstname("Josh_New")
                .lastname("Allen")
                .totalprice(111)
                .depositpaid(true)
                .checkin("2018-01-01")
                .checkout("2019-01-01")
                .additionalneeds("super bowls_the new one")
                .build();

        Response response = RestAssured.given().log().body()
                .body(body)
                .put("/booking/{id}", 33);
        response.prettyPrint();

    }
}
