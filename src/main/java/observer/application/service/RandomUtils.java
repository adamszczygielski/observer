package observer.application.service;

import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();

    public static int getInt(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }
}
