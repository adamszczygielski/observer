package observer.application.mapper;

import observer.application.dto.SearchDto;
import observer.application.dto.Source;
import observer.application.dto.Status;
import observer.application.model.Search;
import observer.application.model.SearchView;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchMapper {

    public SearchDto toDto(Search search) {
        return SearchDto.builder()
                .id(search.getId())
                .description(search.getDescription())
                .params(search.getParams())
                .lastExecutionDate(search.getLastExecutionDate())
                .intervalMinutes(search.getIntervalMinutes())
                .source(Source.getSource(search.getSourceId()))
                .status(Status.getStatus(search.getStatusId()))
                .build();
    }

    public Search toSearch(SearchDto searchDto) {
        return Search.builder()
                .id(searchDto.getId())
                .description(searchDto.getDescription())
                .params(searchDto.getParams())
                .sourceId(searchDto.getSource().getId())
                .statusId(Status.PENDING.getId())
                .intervalMinutes(searchDto.getIntervalMinutes())
                .items(Collections.emptyList())
                .build();
    }

    public List<SearchDto> toDtos(List<SearchView> searchViews) {
        return searchViews.stream()
                .map(s -> SearchDto.builder()
                        .id(s.getId())
                        .description(s.getDescription())
                        .source(Source.getSource(s.getSourceId()))
                        .params(s.getParams())
                        .status(toStatus(s))
                        .lastExecutionDate(s.getLastExecutionDate())
                        .intervalMinutes(s.getIntervalMinutes())
                        .count(s.getCount())
                        .build()).collect(Collectors.toList());
    }

    private Status toStatus(SearchView searchView) {
        Status status = Status.getStatus(searchView.getStatusId());
        if (status == Status.SUCCESS) {
            boolean isOverdue = searchView.getLastExecutionDate()
                    .plus(searchView.getIntervalMinutes(), ChronoUnit.MINUTES)
                    .isBefore(Instant.now());
            if (isOverdue) {
                return Status.PENDING;
            }
        }
        return status;
    }
}