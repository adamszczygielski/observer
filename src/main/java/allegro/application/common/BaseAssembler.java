package allegro.application.common;

import java.util.List;
import java.util.stream.Collectors;

public interface BaseAssembler<F,T> {

    public T toDto(F from);

    default public List<T> toDtoList(List<F> elements) {

        return elements.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}