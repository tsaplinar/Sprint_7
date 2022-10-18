package courier.creation;

import generators.CourierGenerator;
import helpers.Steps;
import io.restassured.response.Response;
import models.Courier;
import org.junit.Test;

public class CourierCreationNegativeTest {
    Steps step = new Steps();

    @Test
    public void courierCreationPasswordOnlyTest() {
        Courier courier = CourierGenerator.createUserPasswordOnly();
        Response response = step.createCourier(courier);
        step.badRequestMessageAndStatusCheck(response);
    }

    @Test
    public void courierCreationLoginOnlyTest() {
        Courier courier = CourierGenerator.createUserLoginOnly();
        Response response = step.createCourier(courier);
        step.badRequestMessageAndStatusCheck(response);
    }

    @Test
    public void courierCreationFirstNameOnlyTest() {
        Courier courier = CourierGenerator.createUserFirstNameOnly();
        Response response = step.createCourier(courier);
        step.badRequestMessageAndStatusCheck(response);
    }
}