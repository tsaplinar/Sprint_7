import helpers.Steps;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;


public class OrderListGettingTest {
    Steps step = new Steps();

    @Test
    public void getOrderListTest() {
        Response responseList = step.getOrderList();
        step.getOrderlistResponseCheck(responseList);
    }

    @After
    public void clearData() {
        step.cancelOrder();
        step.deleteOrderId();
    }
}