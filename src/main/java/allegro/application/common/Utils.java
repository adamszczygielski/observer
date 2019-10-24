package allegro.application.common;

import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Utils {

    private static final TimeZone polishTimeZone = TimeZone.getTimeZone("Europe/Warsaw");

    public static String itemIdToUrl(String itemId) {
        if(StringUtils.isEmpty(itemId)) {
            return "";
        }
        return "https://allegro.pl/i" + itemId + ".html";
    }

    public static String timestampToShortString(Timestamp timestamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(polishTimeZone);
        return simpleDateFormat.format(timestamp);
    }

    public static String keywordNormalizer(String input) {
        return Normalizer
                .normalize(input, Normalizer.Form.NFD)
                .substring(0, Math.min(input.length(), 30))
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll(" +", " ")
                .toLowerCase();
    }
}