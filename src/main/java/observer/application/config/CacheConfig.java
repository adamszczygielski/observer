package observer.application.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    public static final String ALLEGRO_CATEGORY_CACHE = "allegroCategoryCache";
    public static final String OLX_CATEGORY_CACHE = "olxCategoryCache";

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(ALLEGRO_CATEGORY_CACHE, OLX_CATEGORY_CACHE);
    }
}
