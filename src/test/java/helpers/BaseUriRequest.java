package helpers;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseUriRequest {
    private static RequestSpecification requestSpecification;

    public static RequestSpecification getRequestSpecification() {
        requestSpecification = RestAssured.given()
                .baseUri("http://qa-scooter.praktikum-services.ru");
        return requestSpecification;
    }
}
