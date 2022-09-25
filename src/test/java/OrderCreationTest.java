import helpers.Steps;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;

import java.io.File;

public class OrderCreationTest {
    Steps step = new Steps();




    @Test
    public void orderCreationBlackColourTest() {
        File newOrder = new File("src/test/java/resources/orderData/orderCreationBlackColour.json");
        Response response = step.createOrder(newOrder);
        step.orderCreationResponseCheck(response);
    }

    @Test
    public void orderCreationGreyColourTest() {
        File newOrder = new File("src/test/java/resources/orderData/orderCreationGreyColour.json");
        Response response = step.createOrder(newOrder);
        step.orderCreationResponseCheck(response);
    }

    @Test
    public void orderCreationBothColoursTest() {
        File newOrder = new File("src/test/java/resources/orderData/orderCreationBothColours.json");
        Response response = step.createOrder(newOrder);
        step.orderCreationResponseCheck(response);
    }

    @Test
    public void orderCreationNoColour() {
        File newOrder = new File("src/test/java/resources/orderData/orderCreationNoColour.json");
        Response response = step.createOrder(newOrder);
        step.orderCreationResponseCheck(response);
    }

    @After
    public void clearData() {
        step.cancelOrder();
        step.deleteOrderId();
    }
}