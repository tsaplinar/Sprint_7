package order.creation;

import generators.OrderGenerator;
import helpers.Steps;
import io.restassured.response.Response;
import models.Order;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class OrderCreationTest {
    Steps step = new Steps();
    Integer orderId;

    private List<String> colors;

    public OrderCreationTest(List<String> colors) {
        this.colors = colors;
    }

    @Parameterized.Parameters
    public static Collection<Object> data() {
        List<String> withoutColor = new ArrayList<>();
        List<String> blackColor = new ArrayList<>();
        blackColor.add("BLACK");
        List<String> greyColor = new ArrayList<>();
        greyColor.add("GREY");
        List<String> bothColor = new ArrayList<>();
        bothColor.add("BLACK");
        bothColor.add("GREY");
        return Arrays.asList(new Object[] {
                withoutColor,
                blackColor,
                greyColor,
                bothColor
        });
    }

    @Test
    public void orderCreationBlackColourTest() {
        Order order = OrderGenerator.createOrderWithoutColors();
        order.setColor(colors);
        Response response = step.createOrder(order);
        orderId = step.orderCreationResponseCheck(response);
    }

    @After
    public void clearData() {
        step.cancelOrder(orderId);
    }
}