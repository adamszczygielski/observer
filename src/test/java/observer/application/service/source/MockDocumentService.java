package observer.application.service.source;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MockDocumentService extends DocumentService {

    private String pageSource = "";

    public void setPageSource(String pageSource) {
        this.pageSource = pageSource;
    }

    @Override
    public Document getDocument(String url) {
        return Jsoup.parse(pageSource, url);
    }
}
