package observer.application.service.source;

import observer.application.config.ApplicationConfig;
import observer.application.config.MockConfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

public class SourceServiceTest {

    protected final ApplicationConfig mockConfig = new MockConfig();

    protected static String createPageSource(String pathname) {
        File file = new File(pathname);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (FileNotFoundException e) {
            throw new IllegalStateException("File " + file.getName() + " not found!");
        }
    }
}
