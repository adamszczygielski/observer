package observer.application.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import java.text.Normalizer;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapperUtils {

    private static final char ELLIPSIS = '\u2026';

    public static LocalTime toLocalTime(@Nullable Instant date) {
        if (date != null) {
            return LocalTime.from(date.atZone(ZoneId.systemDefault())).truncatedTo(ChronoUnit.SECONDS);
        }
        return null;
    }

    public static String normalize(String input) {
        return Normalizer
                .normalize(input, Normalizer.Form.NFD)
                .substring(0, Math.min(input.length(), 30))
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll(" +", " ")
                .toLowerCase();
    }

    public static String trim(String string, int max) {
        if (string != null && string.length() > max) {
            return string.substring(0, max - 1) + ELLIPSIS;
        }
        return string;
    }

}