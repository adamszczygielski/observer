package observer.application.service;

import org.openqa.selenium.Dimension;

import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();

    public static Dimension getDimension() {
        return new Dimension(getInt(800, 1920), getInt(600, 1200));
    }

    public static long randomize(long seconds, double delta) {
        return getInt((int) (seconds - delta), (int) (seconds + delta));
    }

    public static String randomizeCase(String string) {
        StringBuilder sb = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (RANDOM.nextBoolean()) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static int getInt(int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }

}
