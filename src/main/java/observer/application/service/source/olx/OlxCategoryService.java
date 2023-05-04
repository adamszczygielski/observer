package observer.application.service.source.olx;

import lombok.RequiredArgsConstructor;
import observer.application.model.Category;
import observer.application.service.source.DocumentService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
class OlxCategoryService {

    private static final String URL = "https://www.olx.pl/sitemap/";
    private final DocumentService documentService;

    public List<Category> fetchCategories(String parentId) {
        Document document = documentService.getDocument(URL);
        if (document == null) {
            return Collections.emptyList();
        }

        Elements elements = document.select("h3 > a");
        List<Category> categories = new ArrayList<>(elements.size());

        for (Element e : elements) {
            String categoryUrl = e.attr("href");
            categories.add(
                    Category.builder()
                            .id(getId(categoryUrl))
                            .name(e.text())
                            .leaf(true)
                            .build()
            );
        }

        return categories;
    }

    private String getId(String categoryUrl) {
        return categoryUrl
                .replace("https://www.olx.pl/", "")
                .replace("/", "");
    }

}
