package helpers;

import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class OrderRequests extends BaseUriRequest {
    Integer orderId = null;
    private final static String API_ORDERS = "/api/v1/orders";

    public Response createOrder(File file) {
        Response response =
                given()
                        .spec(getRequestSpecification())
                        .header("Content-type", "application/json")
                        .and()
                        .body(file)
                        .when()
                        .post(API_ORDERS);
        saveOrderId(response);
        return response;
    }

    public void cancelOrder() {
        if (!(orderId == null)) {
            given()
                    .spec(getRequestSpecification())
                    .header("Content-type", "application/json")
                    .when()
                    .put(API_ORDERS + "/cancel?track={track}", orderId);
        }
    }

    public Response getOrderList() {
        return
                given()
                        .spec(getRequestSpecification())
                        .get(API_ORDERS);
    }

    public void saveOrderId(Response response) {
        orderId = response.then().extract().body().path("track");
    }

    public void deleteOrderId() {
        orderId = null;
    }
}