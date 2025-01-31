package observer.application.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface BaseMapper<F, T> {

    T toDto(F from);

    default List<T> toDtoList(List<F> elements) {
        return elements.stream()
                .map(this::toDto)
               .toList();
    }
}