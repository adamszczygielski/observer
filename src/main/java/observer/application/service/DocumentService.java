package observer.application.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DocumentService {

    private static final short TIMEOUT_MILLIS = 5000;

    public Document getDocument(String url) {
        Connection connection = Jsoup.connect(url).timeout(TIMEOUT_MILLIS);
        try {
            return connection.get();
        } catch (IOException e) {
            throw new IllegalStateException("Could not fetch page content!");
        }
    }
}
