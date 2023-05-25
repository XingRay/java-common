package com.xingray.java.util;


import java.lang.invoke.SerializedLambda;
import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ObjectUtil {

    public static <T> boolean hasValue(T obj) {
        return obj != null;
    }

    public static <T> T mapToObject(Map<String, Object> map, Class<T> cls) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        T instance = null;
        try {
            instance = cls.getConstructor().newInstance();
        } catch (Exception ignored) {

        }
        if (instance == null) {
            return null;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            ReflectUtil.set(instance, key, value);
        }

        return instance;
    }

    public static <T> Map<String, Object> objectToMap(T t) {
        if (t == null) {
            return null;
        }
        Field[] fields = t.getClass().getDeclaredFields();
        int size = fields.length;
        if (size == 0) {
            return null;
        }
        Map<String, Object> map = new HashMap<>(size);
        for (Field field : fields) {
            String fieldName = field.getName();
            map.put(fieldName, ReflectUtil.get(t, fieldName));
        }

        return map;
    }

    /**
     * 填充对象
     */
    public static <T> T populateObject(T t, Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return t;
        }
        if (t == null) {
            return t;
        }

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            ReflectUtil.set(t, key, value);
        }

        return t;
    }

    public static <T, M extends Map<String, Object>> M populateMap(T t, M map) {
        if (t == null) {
            return map;
        }
        Field[] fields = t.getClass().getDeclaredFields();
        if (fields.length == 0) {
            return map;
        }

        for (Field field : fields) {
            String fieldName = field.getName();
            map.put(fieldName, ReflectUtil.get(t, fieldName));
        }

        return map;
    }


    public static Object ensureMatchesType(Object value, Class<?> type) {
        if (value == null) {
            return null;
        }

        if (type.isInstance(value) || type.isAssignableFrom(value.getClass())) {
            return value;
        }

        if (type == String.class) {
            return StringUtil.toString(value);
        } else if (type == Long.class) {
            return NumberUtil.toLong(value);
        } else if (type == long.class) {
            return NumberUtil.toLongValue(value);
        } else if (type == Integer.class) {
            return NumberUtil.toInteger(value);
        } else if (type == int.class) {
            return NumberUtil.toIntValue(value);
        } else if (type == Double.class) {
            return NumberUtil.toDouble(value);
        } else if (type == double.class) {
            return NumberUtil.toDoubleValue(value);
        } else if (type == Float.class) {
            return NumberUtil.toFloat(value);
        } else if (type == float.class) {
            return NumberUtil.toFloatValue(value);
        } else if (type == Boolean.class) {
            return NumberUtil.toBoolean(value);
        } else if (type == boolean.class) {
            return NumberUtil.toBooleanValue(value);
        } else if (type == Byte.class) {
            return NumberUtil.toByte(value);
        } else if (type == byte.class) {
            return NumberUtil.toByteValue(value);
        } else if (type == Short.class) {
            return NumberUtil.toShort(value);
        } else if (type == short.class) {
            return NumberUtil.toShortValue(value);
        } else if (type == Character.class) {
            return NumberUtil.toCharacter(value);
        } else if (type == char.class) {
            return NumberUtil.toCharValue(value);
        }

        return null;
    }

    public static Object stringArrayToTypeArray(String[] array, Class<?> elementType) {
        if (array == null) {
            return null;
        }

        if (elementType.equals(String.class)) {
            return array;
        }

        Object targetArray = Array.newInstance(elementType, array.length);
        if (elementType == Long.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toLong(array[i]));
            }
        } else if (elementType == long.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toLongValue(array[i]));
            }
        } else if (elementType == Integer.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toInteger(array[i]));
            }
        } else if (elementType == int.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toIntValue(array[i]));
            }
        } else if (elementType == Double.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toDouble(array[i]));
            }
        } else if (elementType == double.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toDoubleValue(array[i]));
            }
        } else if (elementType == Float.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toFloat(array[i]));
            }
        } else if (elementType == float.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toFloatValue(array[i]));
            }
        } else if (elementType == Boolean.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toBoolean(array[i]));
            }
        } else if (elementType == boolean.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toBooleanValue(array[i]));
            }
        } else if (elementType == Byte.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toByte(array[i]));
            }
        } else if (elementType == byte.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toByteValue(array[i]));
            }
        } else if (elementType == Short.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toShort(array[i]));
            }
        } else if (elementType == short.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toShortValue(array[i]));
            }
        } else if (elementType == Character.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toCharacter(array[i]));
            }
        } else if (elementType == char.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toCharValue(array[i]));
            }
        }

        return null;
    }

    public static <T> Object arrayToTypeArray(T[] array, Class<?> elementType) {
        if (array == null) {
            return null;
        }

        if (elementType.equals(array.getClass().getComponentType())) {
            return array;
        }

        Object targetArray = Array.newInstance(elementType, array.length);
        if (elementType == Long.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toLong(array[i]));
            }
        } else if (elementType == long.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toLongValue(array[i]));
            }
        } else if (elementType == Integer.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toInteger(array[i]));
            }
        } else if (elementType == int.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toIntValue(array[i]));
            }
        } else if (elementType == Double.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toDouble(array[i]));
            }
        } else if (elementType == double.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toDoubleValue(array[i]));
            }
        } else if (elementType == Float.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toFloat(array[i]));
            }
        } else if (elementType == float.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toFloatValue(array[i]));
            }
        } else if (elementType == Boolean.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toBoolean(array[i]));
            }
        } else if (elementType == boolean.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toBooleanValue(array[i]));
            }
        } else if (elementType == Byte.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toByte(array[i]));
            }
        } else if (elementType == byte.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toByteValue(array[i]));
            }
        } else if (elementType == Short.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toShort(array[i]));
            }
        } else if (elementType == short.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toShortValue(array[i]));
            }
        } else if (elementType == Character.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toCharacter(array[i]));
            }
        } else if (elementType == char.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                Array.set(targetArray, i, NumberUtil.toCharValue(array[i]));
            }
        }

        return null;
    }

    public static <T, R> List<R> arrayToTypeList(T[] array, Class<R> elementType) {
        if (array == null) {
            return null;
        }
        if(array.length==0){
            return Collections.emptyList();
        }

        if (elementType.equals(array.getClass().getComponentType())) {
            return (List<R>) Arrays.asList(array);
        }

        ArrayList list = new ArrayList<>(array.length);
        if (elementType == Long.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                list.add(NumberUtil.toLong(array[i]));
            }
        } else if (elementType == long.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                list.add(NumberUtil.toLongValue(array[i]));
            }
        } else if (elementType == Integer.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                list.add(NumberUtil.toInteger(array[i]));
            }
        } else if (elementType == int.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                list.add(NumberUtil.toIntValue(array[i]));
            }
        } else if (elementType == Double.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                list.add(NumberUtil.toDouble(array[i]));
            }
        } else if (elementType == double.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                list.add(NumberUtil.toDoubleValue(array[i]));
            }
        } else if (elementType == Float.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                list.add(NumberUtil.toFloat(array[i]));
            }
        } else if (elementType == float.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                list.add(NumberUtil.toFloatValue(array[i]));
            }
        } else if (elementType == Boolean.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                list.add(NumberUtil.toBoolean(array[i]));
            }
        } else if (elementType == boolean.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                list.add(NumberUtil.toBooleanValue(array[i]));
            }
        } else if (elementType == Byte.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                list.add(NumberUtil.toByte(array[i]));
            }
        } else if (elementType == byte.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                list.add(NumberUtil.toByteValue(array[i]));
            }
        } else if (elementType == Short.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                list.add(NumberUtil.toShort(array[i]));
            }
        } else if (elementType == short.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                list.add(NumberUtil.toShortValue(array[i]));
            }
        } else if (elementType == Character.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                list.add(NumberUtil.toCharacter(array[i]));
            }
        } else if (elementType == char.class) {
            for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
                list.add(NumberUtil.toCharValue(array[i]));
            }
        }

        return null;
    }

    public static boolean isAllNull(Object... objects) {
        for (Object o : objects) {
            if (o != null) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAtLeastOneIsNotNull(Object... objects) {
        for (Object o : objects) {
            if (o != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNoneNull(Object... objects) {
        for (Object o : objects) {
            if (o == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAtLeastOneIsNull(Object... objects) {
        for (Object o : objects) {
            if (o == null) {
                return true;
            }
        }
        return false;
    }

    public static <T> String columnToString(SFunction<T, ?> column) {
        Method writeReplaceMethod = getInheritableMethod(column.getClass(), "writeReplace", null, Object.class);
        if (writeReplaceMethod == null) {
            return null;
        }

        try {
            SerializedLambda serializedLambda = (SerializedLambda) writeReplaceMethod.invoke(column, (Object[]) null);
            return methodToProperty(serializedLambda.getImplMethodName());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static final Map<Class, String> columnCache = new ConcurrentHashMap<>();
    public static <T> String columnToStringCached(SFunction<T, ?> column) {
        String cachedName = columnCache.get(column.getClass());
        if (cachedName != null) {
            return cachedName;
        }
        String columnName = columnToString(column);
        columnCache.put(column.getClass(), columnName);
        return columnName;
    }

    public static Method getInheritableMethod(Class<?> cl, String name,
                                              Class<?>[] argTypes,
                                              Class<?> returnType) {
        Method meth = null;
        Class<?> defCl = cl;
        while (defCl != null) {
            try {
                meth = defCl.getDeclaredMethod(name, argTypes);
                break;
            } catch (NoSuchMethodException ex) {
                defCl = defCl.getSuperclass();
            }
        }

        if ((meth == null) || (meth.getReturnType() != returnType)) {
            return null;
        }
        meth.setAccessible(true);
        int mods = meth.getModifiers();
        if ((mods & (Modifier.STATIC | Modifier.ABSTRACT)) != 0) {
            return null;
        } else if ((mods & (Modifier.PUBLIC | Modifier.PROTECTED)) != 0) {
            return meth;
        } else if ((mods & Modifier.PRIVATE) != 0) {
            return (cl == defCl) ? meth : null;
        } else {
            return packageEquals(cl, defCl) ? meth : null;
        }
    }

    public static boolean packageEquals(Class<?> cl1, Class<?> cl2) {
        return cl1.getClassLoader() == cl2.getClassLoader() &&
                cl1.getPackageName() == cl2.getPackageName();
    }

    public static String methodToProperty(String name) {
        if (name.startsWith("is")) {
            name = name.substring(2);
        } else if (name.startsWith("get") || name.startsWith("set")) {
            name = name.substring(3);
        } else {
            throw new RuntimeException("Error parsing property name '" + name + "'.  Didn't start with 'is', 'get' or 'set'.");
        }

        if (name.length() == 1 || (name.length() > 1 && !Character.isUpperCase(name.charAt(1)))) {
            name = name.substring(0, 1).toLowerCase(Locale.ENGLISH) + name.substring(1);
        }

        return name;
    }
}
