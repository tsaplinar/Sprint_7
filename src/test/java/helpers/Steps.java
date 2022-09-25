package helpers;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.io.File;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Steps {
    CourierRequests courierRequests = new CourierRequests();
    OrderRequests orderRequests = new OrderRequests();

    @Step("New courier creation")
    public Response createCourier(File file) {
        return courierRequests.createCourier(file);
    }

    @Step("Clear test data")
    public void clearTestData(File file) {
        courierRequests.deleteTestData(file);
    }

    @Step("Courier login")
    public Response courierLogin(File file) {
        return courierRequests.loginCourier(file);
    }

    @Step("Create new order")
    public Response createOrder(File file) {
        return orderRequests.createOrder(file);
    }

    @Step("Delete order ID")
    public void deleteOrderId() {
        orderRequests.deleteOrderId();
    }

    @Step("Cancel Order")
    public void cancelOrder() {
        orderRequests.cancelOrder();
    }

    @Step("Get order list")
    public Response getOrderList() {
        return orderRequests.getOrderList();
    }

    @Step("Bad request message and status check")
    public void badRequestMessageAndStatusCheck(Response response) {
        response.then().assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .and()
                .statusCode(SC_BAD_REQUEST);
    }

    @Step("Courier creation status and body check")
    public void courierCreationResponseCheck(Response response) {
        response.then().assertThat().body("ok", equalTo(true))
                .and()
                .statusCode(SC_CREATED);
    }

    @Step("Conflict login request response check")
    public void conflictLoginRequestResponseCheck(Response response) {
        response.then().assertThat().body("message",
                        equalTo("Этот логин уже используется. Попробуйте другой."))
                .and()
                .statusCode(SC_CONFLICT);
    }

    @Step("Success login response check")
    public void successLoginResponseCheck(Response response) {
        response.then().assertThat().body("id", notNullValue())
                .and()
                .statusCode(SC_OK);
    }

    @Step("Login not found response check")
    public void loginNotFoundResponseCheck(Response response) {
        response.then().assertThat().body("message", equalTo("Учетная запись не найдена"))
                .and()
                .statusCode(SC_NOT_FOUND);
    }

    @Step("Not enough data for login response check")
    public void notEnoughDataForLoginResponseCheck(Response response) {
        response.then().assertThat().body("message", equalTo("Недостаточно данных для входа"))
                .and()
                .statusCode(SC_BAD_REQUEST);
    }

    @Step("Order creation response check")
    public void orderCreationResponseCheck(Response response) {
        response.then().assertThat().body("track", notNullValue())
                .and()
                .statusCode(SC_CREATED);
    }

    @Step("Get order list response ckeck")
    public void getOrderlistResponseCheck(Response response) {
        response.then().assertThat().body("orders[0]", notNullValue())
                .and()
                .statusCode(SC_OK);
    }
}