package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetTest {
    @Test
    public void getBookingIdsTest() {
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getSingleBookingIdsTest() {
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/33");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
