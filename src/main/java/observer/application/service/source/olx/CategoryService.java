package observer.application.service.source.olx;

import observer.application.domain.Category;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "olxCategoryService")
public class CategoryService {

    private static final String URL = "https://www.olx.pl/sitemap/";

    public List<Category> fetchCategories(String parentId) {
        List<Category> categories = new ArrayList<>();
        Document document = getDocument();

        if (document == null) {
            return categories;
        }

        Elements elements = document.select("h3 > a");

        for (Element e : elements) {
            String categoryUrl = e.attr("href");
            categories.add(
                    Category.builder()
                            .id(toId(categoryUrl))
                            .name(e.text())
                            .leaf(true)
                            .build()
            );
        }
        return categories;
    }

    private Document getDocument() {
        Connection connection = Jsoup.connect(URL);
        try {
            return connection.get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String toId(String categoryUrl) {
        return categoryUrl.replace("https://www.olx.pl/", "").replace("/", "");
    }

}
