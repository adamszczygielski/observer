package allegro.application.common;

import allegro.application.wsdl.ArrayOfPriceinfotype;
import allegro.application.wsdl.PriceInfoType;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

public class Utils {

    public static String itemIdToUrl(Long itemId) {
        if(StringUtils.isEmpty(itemId)) {
            return "";
        }

        return "https://allegro.pl/i" + Long.toString(itemId) + ".html";
    }

    public static String priceInfoTypeToString(List<PriceInfoType> priceInfoTypeList) {
        String price = "";
        boolean isFirstIteration = true;

        for(PriceInfoType priceInfoType : priceInfoTypeList) {
                if(isFirstIteration) {
                    price = PriceType.valueOf(priceInfoType.getPriceType().toUpperCase()).priceType + ": " + (int) priceInfoType.getPriceValue();
                    isFirstIteration = false;
                } else {
                    price = price + ", " + PriceType.valueOf(priceInfoType.getPriceType().toUpperCase()).priceType + ": " + (int) priceInfoType.getPriceValue();
                }
        }

        return price;
    }

    public static String timestampToShortString(Timestamp timestamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Warsaw"));
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
