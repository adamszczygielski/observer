package observer.application.mapper;

import observer.application.api.SearchViewDto;
import observer.application.domain.SearchView;
import observer.application.domain.Source;
import observer.application.domain.Status;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static observer.application.mapper.MapperUtils.toLocalTime;
import static observer.application.mapper.MapperUtils.trim;

@Component
public class SearchViewMapper implements BaseMapper<SearchView, SearchViewDto> {

    private static final int MAX_LENGTH = 20;

    @Override
    public SearchViewDto toDto(SearchView searchView) {
        return SearchViewDto.builder()
                .id(searchView.getId())
                .keyword(trim(searchView.getKeyword(), MAX_LENGTH))
                .categoryId(trim(searchView.getCategoryId(), MAX_LENGTH))
                .categoryName(trim(searchView.getCategoryName(), MAX_LENGTH))
                .priceFrom(searchView.getPriceFrom())
                .priceTo(searchView.getPriceTo())
                .source(Source.getSource(searchView.getSourceId()).getLabel())
                .status(getCurrentStatus(searchView).getLabel())
                .dateUpdated(toLocalTime(searchView.getDateUpdated()))
                .timeInterval(searchView.getTimeInterval())
                .count(searchView.getCount())
                .build();
    }

    private Status getCurrentStatus(SearchView searchView) {
        if (isSuccess(searchView) && isOverdue(searchView)) {
            return Status.PENDING;
        }
        return Status.getStatus(searchView.getStatusId());
    }

    private boolean isSuccess(SearchView searchView) {
        return searchView.getStatusId() == Status.SUCCESS.getId();
    }

    private boolean isOverdue(SearchView searchView) {
        return searchView.getDateUpdated()
                .plus(searchView.getTimeInterval(), ChronoUnit.MINUTES)
                .isBefore(Instant.now());
    }

}
