package observer.application.service.source.olx;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import observer.application.model.Category;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class OlxConfig {

    @Bean("categoryCache")
    public LoadingCache<String, List<Category>> getCategoryCache(OlxCategoryService categoryService) {
        return CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(2, TimeUnit.DAYS)
                .build(new CacheLoader<String, List<Category>>() {
                    @Override
                    public List<Category> load(String parentId) {
                        return categoryService.fetchCategories(parentId);
                    }
                });
    }

}
