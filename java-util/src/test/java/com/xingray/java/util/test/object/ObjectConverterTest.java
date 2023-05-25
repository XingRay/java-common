package com.xingray.java.util.test.object;

import com.xingray.java.util.StringUtil;
import com.xingray.java.util.object.ObjectConverter;
import com.xingray.java.util.object.ObjectConverters;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

public class ObjectConverterTest {
    @Test
    public void convertTest() {
        ObjectConverter converter = new ObjectConverter().addDefaultConverters();
        int value1 = converter.convert("11", int.class);
        assert value1 == 11;

        Integer value2 = converter.convert("-20", Integer.class);
        assert value2 == -20;

        Float value3 = converter.convert("11.23f", float.class);
        assert value3 == 11.23f;
    }

    @Test
    public void convertTest2() {
        ObjectConverter converter = new ObjectConverter().addDefaultConverters();
        int[] values = (int[]) converter.stringArrayToTypeArray(new String[]{"11", "-20", "0", "1", "10000"}, int.class);
        System.out.println(StringUtil.toString(values, ","));
        assert values.length == 5;
        assert values[0] == 11;
        assert values[4] == 10000;
    }

    @Test
    public void convertTest3() {
        ObjectConverter converter = new ObjectConverter().addDefaultConverters();
        Integer[] values = (Integer[]) converter.stringArrayToTypeArray(new String[]{"11", "-20", "0", "1", "10000"}, Integer.class);
        System.out.println(StringUtil.toString(values, ","));
        assert values.length == 5;
        assert values[0] == 11;
        assert values[4] == 10000;
    }

    @Test
    public void convertTest4() {
        ObjectConverter converter = new ObjectConverter().addConverter(BigDecimal.class, ObjectConverters.bigDecimalConverter());
        BigDecimal bigDecimal = converter.convert("11.23", BigDecimal.class);
        System.out.println(bigDecimal);
        assert bigDecimal.equals(BigDecimal.valueOf(11.23));
    }

    @Test
    public void convertTest5() {
        ObjectConverter converter = new ObjectConverter().addConverter(Date.class, ObjectConverters.dateConverter("yyyy-MM-dd HH:mm:ss"));
        Date date = converter.convert("2023-05-25 20:27:00", Date.class);
        System.out.println(date);
    }

    @Test
    public void convertTest6() {
        ObjectConverter converter = new ObjectConverter().addConverter(Date.class, ObjectConverters.dateConverter("yyyy-MM-dd HH:mm:ss"));
        try {
            Date date = converter.convert("2023/05/25 20:27:00", Date.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("parse error");
    }
}
