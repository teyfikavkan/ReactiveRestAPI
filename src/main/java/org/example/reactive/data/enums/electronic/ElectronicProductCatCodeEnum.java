package org.example.reactive.data.enums.electronic;

import java.util.List;
import java.util.Random;

public enum ElectronicProductCatCodeEnum{
    ELECTRONIC_PRODUCT_CAT_CODE_ENUM_1,
    ELECTRONIC_PRODUCT_CAT_CODE_ENUM_2,
    ELECTRONIC_PRODUCT_CAT_CODE_ENUM_3,
    ELECTRONIC_PRODUCT_CAT_CODE_ENUM_4;

    private static final List<ElectronicProductCatCodeEnum> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static ElectronicProductCatCodeEnum randomElectronicProductCatCodeEnum()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}