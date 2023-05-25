package com.xingray.java.util.object;

import com.xingray.java.util.NumberUtil;
import com.xingray.java.util.StringUtil;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;

public class ObjectConverter {
    private Map<Class, Function<Object, Object>> converters = new HashMap<>();

    public ObjectConverter() {

    }

    public ObjectConverter addDefaultConverters() {
        addConverter(String.class, StringUtil::toString);
        addConverter(Long.class, NumberUtil::toLong);
        addConverter(long.class, NumberUtil::toLongValue);
        addConverter(Integer.class, NumberUtil::toInteger);
        addConverter(int.class, NumberUtil::toIntValue);
        addConverter(Double.class, NumberUtil::toDouble);
        addConverter(double.class, NumberUtil::toDoubleValue);
        addConverter(Float.class, NumberUtil::toFloat);
        addConverter(float.class, NumberUtil::toFloatValue);
        addConverter(Boolean.class, NumberUtil::toBoolean);
        addConverter(boolean.class, NumberUtil::toBooleanValue);
        addConverter(Byte.class, NumberUtil::toByte);
        addConverter(byte.class, NumberUtil::toByteValue);
        addConverter(Short.class, NumberUtil::toShort);
        addConverter(short.class, NumberUtil::toShortValue);
        addConverter(Character.class, NumberUtil::toCharacter);
        addConverter(char.class, NumberUtil::toCharValue);

        return this;
    }

    public <T> ObjectConverter addConverter(Class<T> cls, Function<Object, T> function) {
        converters.put(cls, (Function<Object, Object>) function);
        return this;
    }

    public <T> T convert(Object src, Class<T> targetType) {
        if (src == null) {
            return null;
        }

        if (targetType.isInstance(src) || targetType.isAssignableFrom(src.getClass())) {
            return (T) src;
        }

        Function<Object, Object> function = converters.get(targetType);
        if (function == null) {
            return null;
        }
        return (T) function.apply(src);
    }

    public Object stringArrayToTypeArray(String[] src, Class<?> elementType) {
        if (src == null) {
            return null;
        }

        if (elementType.equals(String.class)) {
            return Arrays.copyOf(src, src.length);
        }

        Object targetArray = Array.newInstance(elementType, src.length);
        Function<Object, Object> converter = converters.get(elementType);
        if (converter == null) {
            throw new IllegalArgumentException("unsupported type:" + elementType.getName() + ", invoke  ObjectConverter#addConverter() to add converter");
        }

        for (int i = 0, arrayLength = src.length; i < arrayLength; i++) {
            Array.set(targetArray, i, converter.apply(src[i]));
        }
        return targetArray;
    }

    public <T> Object arrayToTypeArray(T[] array, Class<?> elementType) {
        if (array == null) {
            return null;
        }

        if (elementType.equals(array.getClass().getComponentType())) {
            return Arrays.copyOf(array, array.length);
        }

        Function<Object, Object> converter = converters.get(elementType);
        if (converter == null) {
            throw new IllegalArgumentException("unsupported type:" + elementType.getName() + ", invoke  ObjectConverter#addConverter() to add converter");
        }

        Object targetArray = Array.newInstance(elementType, array.length);
        for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
            Array.set(targetArray, i, converter.apply(array[i]));
        }
        return targetArray;
    }

    public <R> List<R> arrayToTypeList(Object array, Class<R> elementType) {
        if (array == null) {
            return null;
        }
        int length = Array.getLength(array);
        if (length == 0) {
            return Collections.emptyList();
        }

        if (elementType.equals(array.getClass().getComponentType())) {
            return (List<R>) Arrays.asList(array);
        }

        Function<Object, Object> converter = converters.get(elementType);
        if (converter == null) {
            throw new IllegalArgumentException("unsupported type:" + elementType.getName() + ", invoke  ObjectConverter#addConverter() to add converter");
        }

        ArrayList list = new ArrayList<>(length);
        for (int i = 0, arrayLength = length; i < arrayLength; i++) {
            list.add(converter.apply(Array.get(array, i)));
        }
        return list;
    }
}
