package helpers;

import com.google.gson.Gson;
import io.restassured.response.Response;
import resources.models.Courier;

import java.io.File;

import static io.restassured.RestAssured.given;

public class CourierRequests extends BaseUriRequest {
    private final static String API_COURIER = "/api/v1/courier/";
    Gson gson = new Gson();
    String json = gson.toJson();

    public Response createCourier(String json) {
        return
                given()
                        .spec(getRequestSpecification())
                        .header("Content-type", "application/json")
                        .and()
                        .body(json)
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