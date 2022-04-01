package observer.application.service;

import org.openqa.selenium.Dimension;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomService {

    private static final String WINDOW_SIZE_ARG = "--window-size=%d,%d";

    private final Random random = new Random();

    public Dimension getDimension() {
        return new Dimension(getInt(800, 1920), getInt(600, 1200));
    }

    public String getWindowSizeArg() {
        Dimension dimension = getDimension();
        return String.format(WINDOW_SIZE_ARG, dimension.width, dimension.height);
    }

    public int randomize(long seconds) {
        double delta = seconds * 0.3;
        return getInt((int) (seconds - delta), (int) (seconds + delta));
    }

    public String randomizeCase(String string) {
        StringBuilder sb = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (random.nextBoolean()) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private int getInt(int min, int max) {
        return random.nextInt(max - min) + min;
    }

}
