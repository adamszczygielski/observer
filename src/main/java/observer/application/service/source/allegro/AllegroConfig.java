package observer.application.service.source.allegro;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import observer.application.service.source.allegro.model.CategoryDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class AllegroConfig {

    @Bean("categoryDtoCache")
    public LoadingCache<String, List<CategoryDto>> getCategoryDtoCache(AllegroCategoryService categoryService) {
        return CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(2, TimeUnit.DAYS)
                .build(new CacheLoader<String, List<CategoryDto>>() {
                    @Override
                    public List<CategoryDto> load(String parentId) {
                        return categoryService.fetchCategories(parentId);
                    }
                });
    }

}
