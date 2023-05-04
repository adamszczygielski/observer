package observer.application.mapper;

import observer.application.dto.SearchViewDto;
import observer.application.model.SearchView;
import observer.application.model.Source;
import observer.application.model.Status;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

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
                .source(Source.getLabel(searchView.getSourceId()))
                .status(getCurrentStatus(searchView).getLabel())
                .lastExecutionDate(searchView.getLastExecutionDate())
                .intervalMinutes(searchView.getIntervalMinutes())
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
        return searchView.getLastExecutionDate()
                .plus(searchView.getIntervalMinutes(), ChronoUnit.MINUTES)
                .isBefore(Instant.now());
    }

}
