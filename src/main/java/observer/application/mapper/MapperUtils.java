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
class MapperUtils {

    private static final char ELLIPSIS = '\u2026';

    static LocalTime toLocalTime(@Nullable Instant date) {
        if (date != null) {
            return LocalTime.from(date.atZone(ZoneId.systemDefault())).truncatedTo(ChronoUnit.SECONDS);
        }
        return null;
    }

    static String normalize(String string) {
        return Normalizer
                .normalize(string, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll(" +", " ")
                .toLowerCase();
    }

    static String trim(@Nullable String string, int maxLength) {
        if (string != null && string.length() > maxLength) {
            return string.substring(0, maxLength - 1) + ELLIPSIS;
        }
        return string;
    }

}