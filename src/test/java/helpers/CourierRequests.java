package helpers;

import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class CourierRequests extends BaseUriRequest {
    private final static String API_COURIER = "/api/v1/courier/";

    public Response createCourier(File file) {
        return
                given()
                        .spec(getRequestSpecification())
                        .header("Content-type", "application/json")
                        .and()
                        .body(file)
                        .when()
                        .post(API_COURIER);
    }

    public void deleteTestData (File file) {
        int courierId;
        Response response = given()
                .spec(getRequestSpecification())
                .header("Content-type", "application/json")
                .and()
                .body(file)
                .when()
                .post(API_COURIER + "login");
        if (!(response.then().extract().body().path("id") == null)) {
            courierId = response.then().extract().body().path("id");
            given()
                    .spec(getRequestSpecification())
                    .delete(API_COURIER + courierId);
        }
    }

    public Response loginCourier (File file) {
        return given()
                .spec(getRequestSpecification())
                .header("Content-type", "application/json")
                .and()
                .body(file)
                .when()
                .post(API_COURIER + "login");
    }
}