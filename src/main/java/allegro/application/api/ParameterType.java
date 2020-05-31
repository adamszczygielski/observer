package allegro.application.api;

import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public enum ParameterType {

    CATEGORY(1L, "Category");

    private static final Map<Long, ParameterType> ENUM_MAP;

    static {
        Map<Long, ParameterType> map = new ConcurrentHashMap<>();
        for (ParameterType parameter : ParameterType.values()) {
            map.put(parameter.id, parameter);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    private final Long id;
    private final String label;

    ParameterType(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public static ParameterType getParameter(Long parameterId) {
        return ENUM_MAP.get(parameterId);
    }
}
