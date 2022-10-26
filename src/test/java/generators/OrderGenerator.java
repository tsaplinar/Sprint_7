package generators;

import models.Order;

import java.util.ArrayList;

public class OrderGenerator {
    public static Order createOrderWithoutColors() {
        return new Order(
                "qatest",
                "last name",
                "Adress test",
                1,
                "8 800 555 3535",
                20,
                "2022-02-22",
                "Comment for test",
                null
        );
    }
    public static Order createBlackOrder() {
        Order order = createOrderWithoutColors();
        order.setColor(new ArrayList<>());
        order.addColor("BLACK");
        return order;
    }
}
