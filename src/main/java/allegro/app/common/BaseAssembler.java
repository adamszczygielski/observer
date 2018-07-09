package allegro.app.common;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface BaseAssembler<F,T> {

    public T toDto(F from);

    default public List<T> toDtoList(List<F> elements) {
        List<T> dtoList =  elements.stream()
                .map(element -> toDto(element))
                .collect(Collectors.toList());

        return dtoList;
    }
}
