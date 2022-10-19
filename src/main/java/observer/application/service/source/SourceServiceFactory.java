package observer.application.service.source;

import observer.application.model.Source;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class SourceServiceFactory {

    private final EnumMap<Source, SourceService> sourceServiceEnumMap;

    public SourceServiceFactory(List<SourceService> sourceServices) {
        sourceServiceEnumMap = sourceServices.stream()
                .collect(Collectors.toMap(
                        SourceService::getSource,
                        Function.identity(),
                        (a, b) -> {
                            throw new IllegalArgumentException("Duplicate keys in classes " + a + "and " + b + ".");
                        },
                        () -> new EnumMap<>(Source.class)));
    }

    public SourceService get(Source source) {
        return sourceServiceEnumMap.get(source);
    }

    public SourceService get(int sourceId) {
        return get(Source.getSource(sourceId));
    }

    public List<SourceService> getAll() {
        return new ArrayList<>(sourceServiceEnumMap.values());
    }

}