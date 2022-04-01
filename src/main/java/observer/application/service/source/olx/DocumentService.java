package observer.application.service.source.olx;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DocumentService {

    Document getDocument(String url) {
        Connection connection = Jsoup.connect(url);
        try {
            return connection.get();
        } catch (IOException e) {
            throw new IllegalStateException("Could not fetch page content!");
        }
    }

}
