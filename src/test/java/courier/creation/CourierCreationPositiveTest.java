package courier.creation;

import generators.CourierGenerator;
import helpers.Steps;
import io.restassured.response.Response;
import models.Courier;
import org.junit.After;
import org.junit.Test;

public class CourierCreationPositiveTest {
    Courier courier;
    Steps step = new Steps();

    @Test
    public void createNewCourierTest() {
        courier = CourierGenerator.createValidCourier();
        Response response = step.createCourier(courier);
        step.courierCreationResponseCheck(response);
    }

    @Test
    public void createSameCouriersTest() {
        courier = CourierGenerator.createValidCourier();
        Response response = step.createCourier(courier);
        step.courierCreationResponseCheck(response);
        response = step.createCourier(courier);
        step.conflictLoginRequestResponseCheck(response);
    }

    @Test
    public void createNewCourierWithOnlyRequiredFieldsTest() {
        courier = CourierGenerator.createValidCourier();
        courier.setFirstName(null);
        Response response = step.createCourier(courier);
        step.courierCreationResponseCheck(response);
    }

    @After
    public void clearData() {
        step.clearCourierTestData(courier);
    }
}