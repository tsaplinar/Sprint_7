package courier.login;

import generators.CourierGenerator;
import helpers.Steps;
import io.restassured.response.Response;
import models.Courier;
import org.junit.*;

public class CourierLoginTest {
    private final Steps step = new Steps();
    private Courier courier;

    @Before
    public void setUp() {
        courier = CourierGenerator.createValidCourier();
        step.createCourier(courier);
    }

    @Test
    public void successLoginCourierTest() {
        Response response = step.courierLogin(courier);
        step.successLoginResponseCheck(response);
    }

    @Test
    public void courierInvalidLoginTest() {
        courier.setLogin(courier.getLogin() + "invalid");
        Response response = step.courierLogin(courier);
        step.loginNotFoundResponseCheck(response);
    }

    @Test
    public void courierInvalidPasswordTest() {
        courier.setPassword(courier.getPassword() + "1");
        Response response = step.courierLogin(courier);
        step.loginNotFoundResponseCheck(response);
    }

    @Test
    public void loginCourierWithoutLoginFieldTest() {
        courier.setLogin(null);
        Response response = step.courierLogin(courier);
        step.notEnoughDataForLoginResponseCheck(response);
    }

    @Ignore("Запрос долго обрабатывается и не отдает ответа")
    @Test
    public void loginCourierWithoutPasswordFieldTest() {
        courier.setPassword(null);
        Response response = step.courierLogin(courier);
        step.notEnoughDataForLoginResponseCheck(response);
    }

    @After
    public void clearData() {
        step.clearCourierTestData(courier);
    }
}