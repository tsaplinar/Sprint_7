package resources.generators;

import resources.models.Courier;

import java.util.Random;

public class courierCreationGenerator {
    private static final Random random = new Random();

    public static Courier createValidCourier() {
        String testLogin = "qa-test-" + random.nextInt(9999);
        String password = "qapass" + random.nextInt(100, 999);
        String firstName = "Random kek";
        return new Courier(testLogin, password, firstName);
    }

    public static Courier createLoginOnly() {
        String testLogin = "qa-test-" + random.nextInt(9999);
        return new Courier(testLogin);
    }

    public static Courier createPasswordOnly() {
        String password = "qapass" + random.nextInt(100, 999);
        return new Courier(password);
    }
}
