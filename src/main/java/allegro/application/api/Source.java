package allegro.application.api;

import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public enum Source {

    ALLEGRO(1L, "Allegro"),
    OLX(2L, "OLX"),
    EBAY(3L, "eBay");

    private static final Map<Long, Source> ENUM_MAP;

    static {
        Map<Long, Source> map = new ConcurrentHashMap<>();
        for (Source source : Source.values()) {
            map.put(source.id, source);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    private final Long id;
    private final String label;

    Source(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public static Source getSource(Long sourceId) {
        return ENUM_MAP.get(sourceId);
    }
}