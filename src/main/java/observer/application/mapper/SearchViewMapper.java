package observer.application.mapper;

import observer.application.dto.SearchViewDto;
import observer.application.model.SearchView;
import observer.application.model.Source;
import observer.application.model.Status;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class SearchViewMapper implements BaseMapper<SearchView, SearchViewDto> {

    @Override
    public SearchViewDto toDto(SearchView searchView) {
        return SearchViewDto.builder()
                .id(searchView.getId())
                .keyword(searchView.getKeyword())
                .categoryId(searchView.getCategoryId())
                .categoryName(searchView.getCategoryName())
                .priceFrom(searchView.getPriceFrom())
                .priceTo(searchView.getPriceTo())
                .source(Source.getSource(searchView.getSourceId()).getLabel())
                .status(getCurrentStatus(searchView).getLabel())
                .dateUpdated(searchView.getDateUpdated())
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
