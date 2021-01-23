package observer.application.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {

    private static final char ELLIPSIS = '\u2026';
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = createSimpleDateFormat();

    public static String toString(Timestamp timestamp) {
        return SIMPLE_DATE_FORMAT.format(timestamp);
    }

    public static String normalize(String input) {
        return Normalizer
                .normalize(input, Normalizer.Form.NFD)
                .substring(0, Math.min(input.length(), 30))
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll(" +", " ")
                .toLowerCase();
    }

    public static Timestamp now() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String trim(String string, int max) {
        if (string != null && string.length() > max) {
            return string.substring(0, max - 1) + ELLIPSIS;
        }
        return string;
    }

    private static SimpleDateFormat createSimpleDateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Warsaw"));
        return simpleDateFormat;
    }
}