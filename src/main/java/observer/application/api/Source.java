package observer.application.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@RequiredArgsConstructor
public enum Source {

    ALLEGRO(1L, "Allegro"),
    OLX(2L, "OLX"),
    EBAY(3L, "eBay");

    private static final Map<Long, Source> ENUM_MAP;

    private final Long id;
    private final String label;

    static {
        Map<Long, Source> map = new ConcurrentHashMap<>();
        for (Source source : Source.values()) {
            map.put(source.id, source);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static Source getSource(Long sourceId) {
        return ENUM_MAP.get(sourceId);
    }
}