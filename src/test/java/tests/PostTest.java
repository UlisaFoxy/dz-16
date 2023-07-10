package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PostTest extends GenerateToken {
    @Test
    public void createNewBookingBook() {

        CreateNewBookingBody body = new CreateNewBookingBody().builder()
                .firstname("TestAPI")
                .lastname("Assure")
                .totalprice(100)
                .depositpaid(true)
                .checkin("2023-07-06")
                .checkout("2023-07-06")
                .additionalneeds("Something important")
                .build();

        Response response = RestAssured.given().log().body()
                .body(body)
                .post("/booking/");
        response.prettyPrint();

    }
}
