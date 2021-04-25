package org.example.reactive.data.enums.sport;

import java.util.List;
import java.util.Random;

public enum SportProductCatCodeEnum {
    SPORT_PRODUCT_CAT_CODE_ENUM_1,
    SPORT_PRODUCT_CAT_CODE_ENUM_2,
    SPORT_PRODUCT_CAT_CODE_ENUM_3,
    SPORT_PRODUCT_CAT_CODE_ENUM_4;

    private static final List<SportProductCatCodeEnum> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static SportProductCatCodeEnum randomSportProductCatCodeEnum(){
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
