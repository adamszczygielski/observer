package allegro.application.common;

import allegro.application.wsdl.PriceInfoType;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class Utils {

    private static final Locale polishLocale = new Locale("pl", "PL");
    private static final TimeZone polishTimeZone = TimeZone.getTimeZone("Europe/Warsaw");

    public static String itemIdToUrl(Long itemId) {

        if(StringUtils.isEmpty(itemId)) {
            return "";
        }

        return "https://allegro.pl/i" + itemId + ".html";
    }

    static String priceInfoTypeToString(List<PriceInfoType> priceInfoTypeList) {

        if(CollectionUtils.isEmpty(priceInfoTypeList)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        priceInfoTypeList.forEach(p -> {
            sb.append(PriceType.valueOf(p.getPriceType().toUpperCase()).priceType)
                    .append(": ").append(floatToCurrency(p.getPriceValue()))
                    .append(", ");
        });

        return sb.substring(0, sb.length() - 2);
    }

    private static String floatToCurrency(Float value) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(polishLocale);

        return numberFormat.format(value);
    }

    public static String timestampToShortString(Timestamp timestamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(polishTimeZone);

        return simpleDateFormat.format(timestamp);
    }

    public static String stringNormalizer(String input) {

        return Normalizer
                .normalize(input, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll(" +", " ")
                .toLowerCase();
    }
}
