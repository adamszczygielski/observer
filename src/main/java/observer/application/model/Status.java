package observer.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@AllArgsConstructor
public enum Status {

    FAILED(-1, "Failed"),
    STOPPED(0, "Stopped"),
    PENDING(1, "Pending"),
    SUCCESS(2, "OK");

    private static final Map<Integer, Status> ENUM_MAP;

    static {
        Map<Integer, Status> map = new ConcurrentHashMap<>();
        for (Status status : Status.values()) {
            map.put(status.id, status);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    private final int id;
    private final String label;

    public static Status getStatus(int statusId) {
        return ENUM_MAP.get(statusId);
    }

}
