package observer.application.service;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Dimension;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Random;

@Service
@Slf4j
public class RandomService {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36";
    private static final String USER_AGENT_ARG = "--user-agent={0}";
    private static final String WINDOW_SIZE_ARG = "--window-size=%d,%d";

    private final Random random = new Random();

    public int getRandomInt(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public Dimension getDimension() {
        int width = getRandomInt(800, 1920);
        int height = getRandomInt(600, 1200);
        return new Dimension(width, height);
    }

    public String getUserAgentArg() {
        return MessageFormat.format(USER_AGENT_ARG, USER_AGENT);
    }

    public String getWindowSizeArg() {
        Dimension dimension = getDimension();
        return String.format(WINDOW_SIZE_ARG, dimension.width, dimension.height);
    }

}
