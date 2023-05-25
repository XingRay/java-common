package com.xingray.java.util.object;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

public class ObjectConverters {
    public static Function<Object, BigDecimal> bigDecimalConverter() {
        return o -> new BigDecimal(o.toString());
    }

    public static Function<Object, Date> dateConverter(String pattern) {
        return o -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            try {
                return simpleDateFormat.parse(o.toString());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
