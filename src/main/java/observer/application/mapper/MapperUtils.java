package observer.application.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.Normalizer;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class MapperUtils {

    static String normalize(String string) {
        return Normalizer
                .normalize(string, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll(" +", " ")
                .toLowerCase();
    }

}