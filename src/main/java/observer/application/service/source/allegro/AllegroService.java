package observer.application.service.source.allegro;

import com.google.common.cache.LoadingCache;
import lombok.AllArgsConstructor;
import observer.application.api.ParameterType;
import observer.application.api.allegro.AllegroCategoryDto;
import observer.application.domain.Item;
import observer.application.domain.Parameter;
import observer.application.domain.Search;
import observer.application.rest.RestInvoker;
import observer.application.service.ItemService;
import observer.application.service.source.allegro.mapper.AllegroMapper;
import observer.application.service.source.allegro.model.CategoryDto;
import observer.application.service.source.allegro.model.ListingOffer;
import observer.application.service.source.allegro.model.ListingResponse;
import observer.application.service.source.allegro.model.ListingResponseOffers;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AllegroService extends ItemService {

    private final AllegroMapper mapper;
    private final TokenService tokenService;
    private final RestInvoker restInvoker;
    private final LoadingCache<String, List<CategoryDto>> categoryDtoCache;

    @Override
    public List<Item> getItems(Search search) {
        List<ListingOffer> listingOffers = fetchListingOffers(search.getKeyword(), search.getCategory(), search.getParameterList());
        return mapper.toItems(listingOffers, search.getId());
    }

    public List<AllegroCategoryDto> getCategories(String parentId) {
        List<CategoryDto> categories = categoryDtoCache.getUnchecked(parentId);
        return mapper.toAllegroCategories(categories);
    }

    private List<ListingOffer> fetchListingOffers(String keyword, String categoryId, List<Parameter> parameters) {
        ListingResponse listingResponse = restInvoker.get(
                createListingRequestUrl(keyword, categoryId, parameters), createHttpEntity(), ListingResponse.class);

        return Optional.of(listingResponse)
                .map(ListingResponse::getItems)
                .map(ListingResponseOffers::getRegular)
                .orElse(new ArrayList<>());
    }

    private HttpEntity<String> createHttpEntity() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.set("Accept", "application/vnd.allegro.public.v1+json");
        requestHeaders.add("Authorization", tokenService.fetchAccessToken());

        return new HttpEntity<>(requestHeaders);
    }

    private String createListingRequestUrl(String keyword, String categoryId, List<Parameter> parameters) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.allegro.pl")
                .pathSegment("offers", "listing")
                .queryParam("phrase", keyword.replaceAll(" ", "+"))
                .queryParam("fallback", "false")
                .queryParam("sort", "-startTime")
                .queryParam("limit", "20");

        if (!StringUtils.isEmpty(categoryId)) {
            uriComponentsBuilder.queryParam("category.id", categoryId);
        }

        if (!CollectionUtils.isEmpty(parameters)) {
            String priceFrom = getParameterValue(parameters, ParameterType.PRICE_FROM);
            if (priceFrom != null) {
                uriComponentsBuilder.queryParam("price_from", priceFrom);
            }

            String priceTo = getParameterValue(parameters, ParameterType.PRICE_TO);
            if (priceTo != null) {
                uriComponentsBuilder.queryParam("price_to", priceTo);
            }
        }

        return uriComponentsBuilder.build().toUriString();
    }

}