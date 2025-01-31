package observer.application.logger;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.io.input.ReversedLinesFileReader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogReader {

    private static final File LOG_FILE = new File("application.log");

    public static synchronized String getApplicationLogs(int limit) {
        List<String> logLines = new LinkedList<>();
        int counter = 0;
        String line;

        try (ReversedLinesFileReader reader = ReversedLinesFileReader.builder()
                .setFile(LOG_FILE)
                .setCharset(StandardCharsets.UTF_8)
                .get()) {
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
