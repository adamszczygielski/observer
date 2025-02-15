package observer.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@RequiredArgsConstructor
public enum Source {

    ALLEGRO(1, "Allegro"),
    OLX(2, "OLX"),
    EBAY(3, "eBay"),
    ALLEGRO_LOKALNIE(4, "Allegro Lokalnie"),
    LOOMBARD(5, "Loombard"),
    RSS(6, "RSS");

    private static final Map<Integer, Source> ENUM_MAP;

    private final int id;
    private final String label;

    static {
        Map<Integer, Source> map = new ConcurrentHashMap<>();
        for (Source source : Source.values()) {
            map.put(source.id, source);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static String getLabel(int sourceId) {
        return getSource(sourceId).getLabel();
    }

    public static Source getSource(int sourceId) {
        return ENUM_MAP.get(sourceId);
    }
}