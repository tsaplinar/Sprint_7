import helpers.Steps;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;

import java.io.File;

public class CourierCreationTest {
    File newCourier = new File("src/test/java/resources/courierCreationData/courierCreationFullValid.json");
    Steps step = new Steps();

    @Test
    public void createNewCourierTest() {
        Response response = step.createCourier(newCourier);
        step.courierCreationResponseCheck(response);
    }

    @Test
    public void createSameCouriersTest() {
        step.createCourier(newCourier);
        Response response = step.createCourier(newCourier);
        step.conflictLoginRequestResponseCheck(response);
    }

    @Test
    public void createNewCourierWithOnlyRequiredFieldsTest() {
        Response response = step.createCourier(newCourier);
        step.courierCreationResponseCheck(response);
    }

    @Test
    public void courierCreationPasswordOnlyTest() {
        File newCourier = new File("src/test/java/resources/courierCreationData/courierCreationPasswordOnly.json");
        Response response = step.createCourier(newCourier);
        step.badRequestMessageAndStatusCheck(response);
    }

    @Test
    public void courierCreationLoginOnlyTest() {
        File newCourier = new File("src/test/java/resources/courierCreationData/courierCreationLoginOnly.json");
        Response response = step.createCourier(newCourier);
        step.badRequestMessageAndStatusCheck(response);

    }

    @Test
    public void courierCreationFirstNameOnlyTest() {
        File newCourier = new File("src/test/java/resources/courierCreationData/courierCreationFirstNameOnly.json");
        Response response = step.createCourier(newCourier);
        step.badRequestMessageAndStatusCheck(response);

    }

    @After
    public void clearData() {
        step.clearTestData(newCourier);
    }
}