package observer.application.service.source.allegro;

import observer.application.config.ApplicationConfig;
import observer.application.rest.RestInvoker;
import observer.application.service.source.allegro.model.category.CategoriesDto;
import observer.application.service.source.allegro.model.category.CategoryDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static observer.application.config.CacheConfig.ALLEGRO_CATEGORY_CACHE;

@Service
class AllegroCategoryService {

    private final RestInvoker restInvoker;
    private final AuthorizationService authorizationService;

    public AllegroCategoryService(RestInvoker restInvoker, ApplicationConfig applicationConfig) {
        this.restInvoker = restInvoker;
        this.authorizationService = new AuthorizationService(restInvoker, applicationConfig);
    }

    @Cacheable(ALLEGRO_CATEGORY_CACHE)
    public List<CategoryDto> fetchCategories(String parentId) {
        CategoriesDto categoriesDto = restInvoker.get(
                createCategoryRequestUrl(parentId), createHttpEntity(), CategoriesDto.class);

        return Optional.of(categoriesDto)
                .map(CategoriesDto::getCategories)
                .orElseGet(ArrayList::new);
    }

    private HttpEntity<String> createHttpEntity() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.set("Accept", "application/vnd.allegro.public.v1+json");
        requestHeaders.add("Authorization", authorizationService.fetchBearerToken());
        return new HttpEntity<>(requestHeaders);
    }

    private String createCategoryRequestUrl(String parentId) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.allegro.pl")
                .pathSegment("sale", "categories");

        if (!parentId.equals("0")) {
            uriComponentsBuilder.queryParam("parent.id", parentId);
        }
        return uriComponentsBuilder.build().toUriString();
    }

}
