package allegro.app.common;

import allegro.app.wsdl.ArrayOfPriceinfotype;
import allegro.app.wsdl.PriceInfoType;
import org.springframework.util.StringUtils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

public class Utils {

    public static String itemIdToUrl(Long itemId) {
        if(StringUtils.isEmpty(itemId)) {
            return "";
        }
        return "https://allegro.pl/i" + Long.toString(itemId) + ".html";
    }

    public static String priceToString(ArrayOfPriceinfotype arrayOfPriceinfotype) {
        String price = "";
        boolean isFirstIteration = true;
        final List<String> priceTypeList = Arrays.asList("buyNow","bidding","advert");

        for(PriceInfoType priceInfoType : arrayOfPriceinfotype.getItem()) {
            if(priceTypeList.contains(priceInfoType.getPriceType())) {
                if(isFirstIteration) {
                    price = priceInfoType.getPriceType() + ": " + (int) priceInfoType.getPriceValue();
                    isFirstIteration = false;
                } else {
                    price = price + ", " + priceInfoType.getPriceType() + ": " + (int) priceInfoType.getPriceValue();
                }
            }
        }
        return price;
    }

    public static String timestampToShortString(Timestamp timestamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
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
