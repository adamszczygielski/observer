package observer.application.service.source;

import observer.application.config.ApplicationConfig;
import observer.application.config.MockConfig;
import observer.application.dto.Source;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class SourceServiceTest {

    private static final String TEST_DIRECTORY = "F:/projects/observer/test";
    protected final ApplicationConfig mockConfig = new MockConfig();

    protected static String createPageSource(Source source, String filename) {
        File file = new File(TEST_DIRECTORY + "/" + source.name().toLowerCase() + "/" + filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new IllegalStateException("Could not read file: " + file.getPath());
        }
    }
}
