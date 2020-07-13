package allegro.application.common;

import java.sql.Timestamp;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Utils {

    private static final TimeZone TIME_ZONE = TimeZone.getTimeZone("Europe/Warsaw");
    private static final String DATE_PATTERN = "HH:mm:ss";

    private Utils() {
    }

    public static String toString(Timestamp timestamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
        simpleDateFormat.setTimeZone(TIME_ZONE);
        return simpleDateFormat.format(timestamp);
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
}