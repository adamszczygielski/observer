package observer.application.service;

import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();

    public static long randomizeValue(long val, double delta) {
        return getInt((int) (val - delta), (int) (val + delta));
    }

    public static String randomizeCase(String string) {
        StringBuilder sb = new StringBuilder();
        for (char c : string.toCharArray()) {
            sb.append(RANDOM.nextBoolean() ? Character.toUpperCase(c) : c);
        }
        return sb.toString();
    }

    public static int getInt(int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }

}
