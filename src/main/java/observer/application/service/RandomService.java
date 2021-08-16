package observer.application.service;

import org.openqa.selenium.Dimension;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Random;

@Service
public class RandomService {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36";
    private static final String USER_AGENT_ARG = "--user-agent={0}";
    private static final String WINDOW_SIZE_ARG = "--window-size=%d,%d";

    private final Random random = new Random();

    public Dimension getDimension() {
        int width = getInt(800, 1920);
        int height = getInt(600, 1200);
        return new Dimension(width, height);
    }

    public String getUserAgentArg() {
        return MessageFormat.format(USER_AGENT_ARG, USER_AGENT);
    }

    public String getWindowSizeArg() {
        Dimension dimension = getDimension();
        return String.format(WINDOW_SIZE_ARG, dimension.width, dimension.height);
    }

    public long getDelay(long millis) {
        int min = (int) (millis - (millis * 0.3));
        int max = (int) (millis + (millis * 0.3));
        return getInt(min, max);
    }

    private int getInt(int min, int max) {
        return random.nextInt(max - min) + min;
    }

}
