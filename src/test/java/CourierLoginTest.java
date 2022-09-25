import helpers.Steps;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;

public class CourierLoginTest {
    File loginNewCourier = new File("src/test/java/resources/loginAuthData/courierLoginFullValid.json");
    Steps step = new Steps();

    @Before
    public void createData(){
        step.createCourier(loginNewCourier);
    }
    @Test
    public void successLoginCourierTest() {
        Response response = step.courierLogin(loginNewCourier);
        step.successLoginResponseCheck(response);
    }

    @Test
    public void courierInvalidLoginTest() {File loginCourier = new File("src/test/java/resources/loginAuthData/courierInvalidLogin.json");
        Response response = step.courierLogin(loginCourier);
        step.loginNotFoundResponseCheck(response);
    }

    @Test
    public void courierInvalidPasswordTest() {
        File loginCourier = new File("src/test/java/resources/loginAuthData/courierInvalidPassword.json");
        Response response = step.courierLogin(loginCourier);
        step.loginNotFoundResponseCheck(response);
    }

    @Test
    public void loginCourierWithoutLoginFieldTest() {
        File loginCourier = new File("src/test/java/resources/loginAuthData/courierLoginPasswordOnly.json");
        Response response = step.courierLogin(loginCourier);
        step.notEnoughDataForLoginResponseCheck(response);
    }

    @Ignore("Запрос долго обрабатывается и не отдает ответа")
    @Test
    public void loginCourierWithoutPasswordFieldTest() {
        File loginCourier = new File("src/test/java/resources/loginAuthData/courierLoginOnlyLogin.json");
        Response response = step.courierLogin(loginCourier);
        step.notEnoughDataForLoginResponseCheck(response);
    }

    @After
    public void clearData() {
        step.clearTestData(loginNewCourier);
    }
}