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
        List<String> logLines = new ArrayList<>();
        try (ReversedLinesFileReader reader = new ReversedLinesFileReader(LOG_FILE, StandardCharsets.UTF_8)) {
            short counter = 0;
            String line;
            while ((line = reader.readLine()) != null && counter++ < limit) {
                logLines.add(line);
            }
        } catch (IOException e) {
            return "Error reading log file!";
        }

        Collections.reverse(logLines);
        return toString(logLines);
    }

    private String toString(List<String> logLines) {
        StringBuilder stringBuilder = new StringBuilder();
        logLines.forEach(s -> stringBuilder.append(s).append("\n"));
        return stringBuilder.toString();
    }

}
