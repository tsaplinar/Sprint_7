package order.creation;

import generators.OrderGenerator;
import helpers.Steps;
import io.restassured.response.Response;
import models.Order;
import org.junit.After;
import org.junit.Test;

import java.io.File;

public class OrderCreationTest {
    Steps step = new Steps();
    Integer orderId;

    @Test
    public void orderCreationBlackColourTest() {
        Order order = OrderGenerator.createBlackOrder();
        Response response = step.createOrder(order);
        orderId = step.orderCreationResponseCheck(response);
    }

    @Test
    public void orderCreationGreyColourTest() {
        Order order = OrderGenerator.createGreyOrder();
        Response response = step.createOrder(order);
        orderId = step.orderCreationResponseCheck(response);
    }

    @Test
    public void orderCreationBothColoursTest() {
        Order order = OrderGenerator.createBothColorOrder();
        Response response = step.createOrder(order);
        orderId = step.orderCreationResponseCheck(response);
    }

    @Test
    public void orderCreationNoColour() {
        Order order = OrderGenerator.createOrderWithoutColors();
        Response response = step.createOrder(order);
        orderId = step.orderCreationResponseCheck(response);
    }

    @After
    public void clearData() {
        step.cancelOrder(orderId);
    }
}