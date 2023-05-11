package observer.application.logger;

import org.apache.commons.io.input.ReversedLinesFileReader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogReader {

    private static final File LOG_FILE = new File("application.log");

    public String getApplicationLogs(int limit) {
        List<String> logLines = new ArrayList<>(limit);
        try (ReversedLinesFileReader reader = new ReversedLinesFileReader(LOG_FILE, StandardCharsets.UTF_8)) {
            int counter = 0;
            String line;
            while ((line = reader.readLine()) != null && counter++ < limit) {
                logLines.add(line);
            }
        } catch (IOException e) {
            return "Error reading log file!";
        }
        Collections.reverse(logLines);
        return String.join("\n", logLines);
    }
}
