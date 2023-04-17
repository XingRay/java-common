package com.xingray.java.util.collection;


import com.xingray.java.base.interfaces.*;
import com.xingray.java.base.range.DoubleRange;
import com.xingray.java.base.range.IntRange;
import com.xingray.java.base.range.LongRange;
import com.xingray.java.collection.array.Array;
import com.xingray.java.collection.series.DoubleSeries;
import com.xingray.java.collection.series.IntSeries;
import com.xingray.java.collection.series.LongSeries;
import com.xingray.java.collection.series.Series;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * @author : leixing
 * @date : 2017-02-20
 * Email       : leixing@baidu.com
 * Version     : 0.0.1
 * <p>
 * Description : util for collection
 * <p>
 * // TODO: 2018/6/25 Collection -> Iterable
 * // TODO: 2018/6/25 局部变量使用真实类型
 * // TODO: 2018/6/26 泛型界定
 */

@SuppressWarnings({"WeakerAccess", "unused", "BooleanMethodIsAlwaysInverted", "unchecked"})
public class CollectionUtil {

    private static final int[] EMPTY_INT_ARRAY = new int[0];

    private static final long[] EMPTY_LONG_ARRAY = new long[0];

    private static final double[] EMPTY_DOUBLE_ARRAY = new double[0];

    private CollectionUtil() {
        throw new UnsupportedOperationException();
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        //noinspection rawtypes
        return iterable == null || (iterable instanceof Collection && isEmpty((Collection) iterable))
                || !iterable.iterator().hasNext();
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(boolean[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(byte[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(char[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(int[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(long[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(float[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(double[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(Series<?> series) {
        return series == null || series.length() == 0;
    }

    public static boolean isEmpty(IntSeries series) {
        return series == null || series.length() == 0;
    }

    public static boolean isEmpty(LongSeries series) {
        return series == null || series.length() == 0;
    }

    public static boolean isEmpty(DoubleSeries series) {
        return series == null || series.length() == 0;
    }

    public static boolean hasElement(Iterable<?> iterable) {
        return iterable != null && iterable.iterator().hasNext();
    }

    public static boolean hasElement(Collection<?> collection) {
        return collection != null && !collection.isEmpty();
    }

    public static boolean hasElement(Map<?, ?> map) {
        return map != null && !map.isEmpty();
    }

    public static <T> boolean hasElement(T[] array) {
        return array != null && array.length > 0;
    }

    public static boolean hasElement(boolean[] array) {
        return array != null && array.length > 0;
    }

    public static boolean hasElement(byte[] array) {
        return array != null && array.length > 0;
    }

    public static boolean hasElement(char[] array) {
        return array != null && array.length > 0;
    }

    public static boolean hasElement(int[] array) {
        return array != null && array.length > 0;
    }

    public static boolean hasElement(long[] array) {
        return array != null && array.length > 0;
    }

    public static boolean hasElement(float[] array) {
        return array != null && array.length > 0;
    }

    public static boolean hasElement(double[] array) {
        return array != null && array.length > 0;
    }

    public static <T> int size(Iterable<T> iterable) {
        if (iterable == null) {
            return 0;
        }
        if (iterable instanceof Collection) {
            return ((Collection<T>) iterable).size();
        }
        int size = 0;
        for (T e : iterable) {
            size++;
        }
        return size;
    }

    public static int size(Map<?, ?> map) {
        return map == null ? 0 : map.size();
    }

    public static <T> int size(T[] array) {
        return array == null ? 0 : array.length;
    }

    public static int size(boolean[] array) {
        return array == null ? 0 : array.length;
    }

    public static int size(byte[] array) {
        return array == null ? 0 : array.length;
    }

    public static int size(char[] array) {
        return array == null ? 0 : array.length;
    }

    public static int size(int[] array) {
        return array == null ? 0 : array.length;
    }

    public static int size(long[] array) {
        return array == null ? 0 : array.length;
    }

    public static int size(float[] array) {
        return array == null ? 0 : array.length;
    }

    public static int size(double[] array) {
        return array == null ? 0 : array.length;
    }

    public static int size(Series<?> series) {
        return series == null ? 0 : series.length();
    }

    public static int size(IntSeries series) {
        return series == null ? 0 : series.length();
    }

    public static int size(LongSeries series) {
        return series == null ? 0 : series.length();
    }

    public static int size(DoubleSeries series) {
        return series == null ? 0 : series.length();
    }

    public static boolean isValidIndex(Iterable<?> iterable, int index) {
        return index < size(iterable) && index >= 0;
    }

    public static boolean isValidIndex(Collection<?> collection, int index) {
        return index < size(collection) && index >= 0;
    }

    public static boolean isValidIndex(List<?> list, int index) {
        return index < size(list) && index >= 0;
    }

    public static boolean isValidIndex(boolean[] array, int index) {
        return index < size(array) && index >= 0;
    }

    public static <T> boolean isValidIndex(T[] array, int index) {
        return index < size(array) && index >= 0;
    }

    public static boolean isValidIndex(byte[] array, int index) {
        return index < size(array) && index >= 0;
    }

    public static boolean isValidIndex(char[] array, int index) {
        return index < size(array) && index >= 0;
    }

    public static boolean isValidIndex(int[] array, int index) {
        return index < size(array) && index >= 0;
    }

    public static boolean isValidIndex(float[] array, int index) {
        return index < size(array) && index >= 0;
    }

    public static boolean isValidIndex(double[] array, int index) {
        return index < size(array) && index >= 0;
    }

    public static boolean isValidIndex(long[] array, int index) {
        return index < size(array) && index >= 0;
    }

    public static boolean isOutOfIndex(Iterable<?> iterable, int index) {
        return index < 0 || index >= size(iterable);
    }

    public static <T> boolean isOutOfIndex(T[] array, int index) {
        return index < 0 || index >= size(array);
    }

    public static boolean isOutOfIndex(boolean[] array, int index) {
        return index < 0 || index >= size(array);
    }

    public static boolean isOutOfIndex(byte[] array, int index) {
        return index < 0 || index >= size(array);
    }

    public static boolean isOutOfIndex(char[] array, int index) {
        return index < 0 || index >= size(array);
    }

    public static boolean isOutOfIndex(int[] array, int index) {
        return index < 0 || index >= size(array);
    }

    public static boolean isOutOfIndex(float[] array, int index) {
        return index < 0 || index >= size(array);
    }

    public static boolean isOutOfIndex(double[] array, int index) {
        return index < 0 || index >= size(array);
    }

    public static boolean isOutOfIndex(long[] array, int index) {
        return index < 0 || index >= size(array);
    }

    public static <T> boolean hasElementByKey(Map<T, ?> map, T key) {
        return !(map == null || map.isEmpty()) && map.get(key) != null;
    }

    public static <T> boolean hasElementAt(Iterable<T> iterable, int index) {
        if (iterable == null) {
            return false;
        }

        if (iterable instanceof List) {
            return isValidIndex((List<T>) iterable, index)
                    && ((List<T>) iterable).get(index) != null;
        }

        int i = 0;
        for (T t : iterable) {
            if (i == index) {
                return t != null;
            }
            i++;
        }
        return false;
    }

    public static <T> boolean hasElementAt(T[] array, int index) {
        return isValidIndex(array, index) && array[index] != null;
    }

    public static boolean hasElementAt(boolean[] array, int index) {
        return index < size(array) && index >= 0;
    }

    public static boolean hasElementAt(byte[] array, int index) {
        return index < size(array) && index >= 0;
    }

    public static boolean hasElementAt(char[] array, int index) {
        return index < size(array) && index >= 0;
    }

    public static boolean hasElementAt(int[] array, int index) {
        return index < size(array) && index >= 0;
    }

    public static boolean hasElementAt(long[] array, int index) {
        return index < size(array) && index >= 0;
    }

    public static boolean hasElementAt(float[] array, int index) {
        return index < size(array) && index >= 0;
    }

    public static boolean hasElementAt(double[] array, int index) {
        return index < size(array) && index >= 0;
    }

    public static <T> T get(Iterable<T> iterable, int index) {
        if (iterable == null) {
            return null;
        }
        if (iterable instanceof Collection) {
            return get((Collection<T>) iterable, index);
        }
        int i = 0;
        for (T t : iterable) {
            if (i == index) {
                return t;
            }
            i++;
        }
        return null;
    }

    public static <T> T get(Collection<T> collection, int index) {
        if (isOutOfIndex(collection, index)) {
            return null;
        }
        if (collection instanceof List) {
            return get((List<T>) collection, index);
        }
        return (T) collection.toArray()[index];
    }

    public static <T> T get(List<T> list, int index) {
        T t = null;
        if (isValidIndex(list, index)) {
            t = list.get(index);
        }

        return t;
    }

    public static <T> T get(T[] array, int index) {
        T t = null;
        if (isValidIndex(array, index)) {
            t = array[index];
        }

        return t;
    }

    public static <K, V> V get(Map<K, V> map, K key) {
        return map == null ? null : map.get(key);
    }

    public static <T> boolean equals(T t1, T t2) {
        if (t1 == t2) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        return t1.equals(t2);
    }

    public static <T> boolean equals(Set<T> set1, Set<T> set2) {
        if (set1 == set2) {
            return true;
        }
        if (set1 == null || set2 == null) {
            return false;
        }

        if (set1.size() != set2.size()) {
            return false;
        }

        for (T t : set1) {
            if (t == null) {
                continue;
            }

            if (!set2.contains(t)) {
                return false;
            }
        }

        for (T t : set2) {
            if (t == null) {
                continue;
            }

            if (!set1.contains(t)) {
                return false;
            }
        }

        return true;
    }

    public static <K, V> boolean equals(Map<K, V> map1, Map<K, V> map2) {
        if (map1 == map2) {
            return true;
        }
        if (map1 == null || map2 == null) {
            return false;
        }
        Set<K> keySet1 = map1.keySet();
        Set<K> keySet2 = map2.keySet();
        if (!equals(keySet1, keySet2)) {
            return false;
        }

        for (K k : keySet1) {
            if (!equals(map1.get(k), map2.get(k))) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean equals(Iterable<T> list1, Iterable<T> list2) {
        if (list1 == list2) {
            return true;
        }
        if (list1 == null || list2 == null) {
            return false;
        }

        if (list1 instanceof Collection && list2 instanceof Collection
                && ((Collection) list1).size() != ((Collection) list2).size()) {
            return false;
        }

        Iterator<T> iterator1 = list1.iterator();
        Iterator<T> iterator2 = list2.iterator();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            T t1 = iterator1.next();
            T t2 = iterator2.next();
            if (!equals(t1, t2)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean equals(T[] array1, T[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null) {
            return false;
        }
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0, size = array1.length; i < size; i++) {
            if (!equals(array1[i], array2[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(boolean[] array1, boolean[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null) {
            return false;
        }
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0, size = array1.length; i < size; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(byte[] array1, byte[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null) {
            return false;
        }
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0, size = array1.length; i < size; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(char[] array1, char[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null) {
            return false;
        }
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0, size = array1.length; i < size; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(int[] array1, int[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null) {
            return false;
        }
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0, size = array1.length; i < size; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(long[] array1, long[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null) {
            return false;
        }
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0, size = array1.length; i < size; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(float[] array1, float[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null) {
            return false;
        }
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0, size = array1.length; i < size; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(double[] array1, double[] array2) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null) {
            return false;
        }
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0, size = array1.length; i < size; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static <T> void swap(List<T> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static <T> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T> void swap(boolean[] array, int i, int j) {
        boolean tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T> void swap(byte[] array, int i, int j) {
        byte tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T> void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T> void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T> void swap(long[] array, int i, int j) {
        long tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T> void swap(float[] array, int i, int j) {
        float tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T> void swap(double[] array, int i, int j) {
        double tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static int indexOf(boolean[] array, boolean target) {
        return indexOf(array, target, 0);
    }

    public static int indexOf(boolean[] array, boolean target, int startIndex) {
        if (isOutOfIndex(array, startIndex)) {
            return -1;
        }

        for (int i = startIndex, size = array.length; i < size; i++) {
            if (target == array[i]) {
                return i;
            }
        }

        return -1;
    }

    public static int indexOf(byte[] array, byte target) {
        return indexOf(array, target, 0);
    }

    public static int indexOf(byte[] array, byte target, int startIndex) {
        if (isOutOfIndex(array, startIndex)) {
            return -1;
        }

        for (int i = startIndex, size = array.length; i < size; i++) {
            if (target == array[i]) {
                return i;
            }
        }

        return -1;
    }

    public static int indexOf(char[] array, char target) {
        return indexOf(array, target, 0);
    }

    public static int indexOf(char[] array, char target, int startIndex) {
        if (isOutOfIndex(array, startIndex)) {
            return -1;
        }

        for (int i = startIndex, size = array.length; i < size; i++) {
            if (target == array[i]) {
                return i;
            }
        }

        return -1;
    }

    public static int indexOf(int[] array, int target) {
        return indexOf(array, target, 0);
    }

    public static int indexOf(int[] array, int target, int startIndex) {
        if (isOutOfIndex(array, startIndex)) {
            return -1;
        }

        for (int i = startIndex, size = array.length; i < size; i++) {
            if (target == array[i]) {
                return i;
            }
        }

        return -1;
    }

    public static int indexOf(float[] array, float target) {
        return indexOf(array, target, 0);
    }

    public static int indexOf(float[] array, float target, int startIndex) {
        if (isOutOfIndex(array, startIndex)) {
            return -1;
        }

        for (int i = startIndex, size = array.length; i < size; i++) {
            if (target == array[i]) {
                return i;
            }
        }

        return -1;
    }

    public static int indexOf(long[] array, long target) {
        return indexOf(array, target, 0);
    }

    public static int indexOf(long[] array, long target, int startIndex) {
        if (isOutOfIndex(array, startIndex)) {
            return -1;
        }

        for (int i = startIndex, size = array.length; i < size; i++) {
            if (target == array[i]) {
                return i;
            }
        }

        return -1;
    }

    public static <T> int indexOf(T[] array, T target) {
        return indexOf(array, target, 0);
    }

    public static <T> int indexOf(T[] array, T target, int startIndex) {
        if (isOutOfIndex(array, startIndex)) {
            return -1;
        }

        for (int i = startIndex, size = array.length; i < size; i++) {
            if (equals(target, array[i])) {
                return i;
            }
        }

        return -1;
    }


    public static <T> int indexOf(Iterable<T> iterable, T target) {
        return indexOf(iterable, target, 0);
    }

    public static <T> int indexOf(Iterable<T> iterable, T target, int startIndex) {
        if (iterable == null) {
            return -1;
        }

        if (iterable instanceof List && iterable instanceof RandomAccess) {
            List<T> list = (List<T>) iterable;
            for (int i = startIndex, size = list.size(); i < size; i++) {
                if (equals(target, list.get(i))) {
                    return i;
                }
            }
        } else {
            int index = -1;
            for (T t : iterable) {
                index++;
                if (index < startIndex) {
                    continue;
                }
                if (equals(target, t)) {
                    return index;
                }
            }
        }

        return -1;
    }

    public static int indexOf(boolean[] array, Matcher<Boolean> matcher) {
        return indexOf(array, 0, matcher);
    }

    public static int indexOf(boolean[] array, int startIndex, Matcher<Boolean> matcher) {
        if (isOutOfIndex(array, startIndex)) {
            return -1;
        }

        for (int i = 0, size = array.length; i < size; i++) {
            if (matcher.isMatch(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOf(byte[] array, Matcher<Byte> matcher) {
        return indexOf(array, 0, matcher);
    }

    public static int indexOf(byte[] array, int startIndex, Matcher<Byte> matcher) {
        if (isOutOfIndex(array, startIndex)) {
            return -1;
        }

        for (int i = 0, size = array.length; i < size; i++) {
            if (matcher.isMatch(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOf(char[] array, Matcher<Character> matcher) {
        return indexOf(array, 0, matcher);
    }

    public static int indexOf(char[] array, int startIndex, Matcher<Character> matcher) {
        if (isOutOfIndex(array, startIndex)) {
            return -1;
        }

        for (int i = 0, size = array.length; i < size; i++) {
            if (matcher.isMatch(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOf(int[] array, Matcher<Integer> matcher) {
        return indexOf(array, 0, matcher);
    }

    public static int indexOf(int[] array, int startIndex, Matcher<Integer> matcher) {
        if (isOutOfIndex(array, startIndex)) {
            return -1;
        }

        for (int i = 0, size = array.length; i < size; i++) {
            if (matcher.isMatch(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOf(long[] array, Matcher<Long> matcher) {
        return indexOf(array, 0, matcher);
    }

    public static int indexOf(long[] array, int startIndex, Matcher<Long> matcher) {
        if (isOutOfIndex(array, startIndex)) {
            return -1;
        }

        for (int i = 0, size = array.length; i < size; i++) {
            if (matcher.isMatch(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOf(float[] array, Matcher<Float> matcher) {
        return indexOf(array, 0, matcher);
    }

    public static int indexOf(float[] array, int startIndex, Matcher<Float> matcher) {
        if (isOutOfIndex(array, startIndex)) {
            return -1;
        }

        for (int i = 0, size = array.length; i < size; i++) {
            if (matcher.isMatch(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOf(double[] array, Matcher<Double> matcher) {
        return indexOf(array, 0, matcher);
    }

    public static int indexOf(double[] array, int startIndex, Matcher<Double> matcher) {
        if (isOutOfIndex(array, startIndex)) {
            return -1;
        }

        for (int i = 0, size = array.length; i < size; i++) {
            if (matcher.isMatch(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public static <T> int indexOf(T[] array, Matcher<T> matcher) {
        return indexOf(array, 0, matcher);
    }

    public static <T> int indexOf(T[] array, int startIndex, Matcher<T> matcher) {
        if (isOutOfIndex(array, startIndex)) {
            return -1;
        }

        for (int i = 0, size = array.length; i < size; i++) {
            if (matcher.isMatch(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public static <T> int indexOf(Iterable<T> iterable, Matcher<T> matcher) {
        return indexOf(iterable, 0, matcher);
    }

    public static <T> int indexOf(Iterable<T> iterable, int startIndex, Matcher<T> matcher) {
        if (isOutOfIndex(iterable, startIndex)) {
            return -1;
        }
        if (iterable instanceof List && iterable instanceof RandomAccess) {
            List<T> list = (List<T>) iterable;
            for (int i = startIndex, size = list.size(); i < size; i++) {
                if (matcher.isMatch(list.get(i))) {
                    return i;
                }
            }
        } else {
            int index = -1;
            for (T t : iterable) {
                index++;
                if (index < startIndex) {
                    continue;
                }
                if (matcher.isMatch(t)) {
                    return index;
                }
            }
        }

        return -1;
    }

    public static <T> T find(T[] array, Matcher<T> matcher) {
        return find(array, 0, matcher);
    }

    public static <T> T find(T[] array, int startIndex, Matcher<T> matcher) {
        if (isOutOfIndex(array, startIndex)) {
            return null;
        }
        for (int i = startIndex, size = array.length; i < size; i++) {
            T t = array[i];
            if (matcher.isMatch(t)) {
                return t;
            }
        }
        return null;
    }

    public static <T> T find(Iterable<T> iterable, Matcher<T> matcher) {
        return find(iterable, 0, matcher);
    }

    public static <T> T find(Iterable<T> iterable, int startIndex, Matcher<T> matcher) {
        if (isOutOfIndex(iterable, startIndex)) {
            return null;
        }

        if (iterable instanceof List && iterable instanceof RandomAccess) {
            List<T> list = (List<T>) iterable;
            for (int i = startIndex, size = list.size(); i < size; i++) {
                T t = list.get(i);
                if (matcher.isMatch(t)) {
                    return t;
                }
            }
        } else {
            int index = -1;
            for (T t : iterable) {
                index++;
                if (index < startIndex) {
                    continue;
                }
                if (matcher.isMatch(t)) {
                    return t;
                }
            }
        }

        return null;
    }

    public static <T> SearchResult<T> find(T[][] array2, Matcher<T> matcher) {
        return find(array2, 0, 0, matcher);
    }

    public static <T> SearchResult<T> find(T[][] array2, int startIndex0, int startIndex1, Matcher<T> matcher) {
        if (isOutOfIndex(array2, startIndex0)) {
            return null;
        }
        for (int index0 = startIndex0, size0 = array2.length; index0 < size0; index0++) {
            T[] array = array2[index0];
            if (isOutOfIndex(array, startIndex1)) {
                continue;
            }
            for (int index1 = startIndex1, size1 = array.length; index1 < size1; index1++) {
                T t = array[index1];
                if (matcher.isMatch(t)) {
                    return new SearchResult<>(t, index0, index1);
                }
            }
        }
        return null;
    }

    public static <T> ArrayList<T> findAll(T[] array, Matcher<T> matcher) {
        return findAll(array, 0, matcher);
    }

    public static <T> ArrayList<T> findAll(T[] array, int startIndex, Matcher<T> matcher) {
        ArrayList<T> result = new ArrayList<>();

        if (isOutOfIndex(array, startIndex)) {
            return result;
        }

        for (int i = startIndex, size = array.length; i < size; i++) {
            T t = array[i];
            if (matcher.isMatch(t)) {
                result.add(t);
            }
        }

        return result;
    }

    public static <T> ArrayList<T> findAll(Iterable<T> iterable, Matcher<T> matcher) {
        return findAll(iterable, 0, matcher);
    }

    public static <T> ArrayList<T> findAll(Iterable<T> iterable, int startIndex, Matcher<T> matcher) {
        ArrayList<T> result = new ArrayList<>();

        if (isOutOfIndex(iterable, startIndex)) {
            return result;
        }

        if (iterable instanceof List && iterable instanceof RandomAccess) {
            List<T> list = (List<T>) iterable;
            for (int i = startIndex, size = list.size(); i < size; i++) {
                T t = list.get(i);
                if (matcher.isMatch(t)) {
                    result.add(t);
                }
            }
        } else {
            int index = -1;
            for (T t : iterable) {
                index++;
                if (index < startIndex) {
                    continue;
                }
                if (matcher.isMatch(t)) {
                    result.add(t);
                }
            }
        }

        return result;
    }

    public static <T> void filter(Iterable<T> iterable, Filter<T> filter) {
        if (isEmpty(iterable)) {
            return;
        }
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (!filter.keep(t)) {
                iterator.remove();
            }
        }
    }

    public static <T> void move(List<T> list, int fromIndex, int toIndex) {
        if (isOutOfIndex(list, fromIndex)) {
            return;
        }

        if (isOutOfIndex(list, toIndex)) {
            return;
        }

        if (fromIndex == toIndex) {
            return;
        }

        if (fromIndex > toIndex) {
            for (int i = fromIndex; i > toIndex; i--) {
                Collections.swap(list, i, i - 1);
            }
        } else {
            for (int i = fromIndex; i < toIndex; i++) {
                Collections.swap(list, i, i + 1);
            }
        }
    }

    public static <T> void move(T[] array, int fromIndex, int toIndex) {
        if (isOutOfIndex(array, fromIndex)) {
            return;
        }

        if (isOutOfIndex(array, toIndex)) {
            return;
        }

        if (fromIndex == toIndex) {
            return;
        }

        if (fromIndex > toIndex) {
            T temp = array[fromIndex];
            System.arraycopy(array, toIndex, array, toIndex + 1, fromIndex - toIndex);
            array[toIndex] = temp;
        } else {
            T temp = array[fromIndex];
            System.arraycopy(array, fromIndex + 1, array, fromIndex, toIndex - fromIndex);
            array[toIndex] = temp;
        }
    }

    public static <T> void move(boolean[] array, int fromIndex, int toIndex) {
        if (isOutOfIndex(array, fromIndex)) {
            return;
        }

        if (isOutOfIndex(array, toIndex)) {
            return;
        }

        if (fromIndex == toIndex) {
            return;
        }

        if (fromIndex > toIndex) {
            boolean temp = array[fromIndex];
            System.arraycopy(array, toIndex, array, toIndex + 1, fromIndex - toIndex);
            array[toIndex] = temp;
        } else {
            boolean temp = array[fromIndex];
            System.arraycopy(array, fromIndex + 1, array, fromIndex, toIndex - fromIndex);
            array[toIndex] = temp;
        }
    }

    public static <T> void move(byte[] array, int fromIndex, int toIndex) {
        if (isOutOfIndex(array, fromIndex)) {
            return;
        }

        if (isOutOfIndex(array, toIndex)) {
            return;
        }

        if (fromIndex == toIndex) {
            return;
        }

        if (fromIndex > toIndex) {
            byte temp = array[fromIndex];
            System.arraycopy(array, toIndex, array, toIndex + 1, fromIndex - toIndex);
            array[toIndex] = temp;
        } else {
            byte temp = array[fromIndex];
            System.arraycopy(array, fromIndex + 1, array, fromIndex, toIndex - fromIndex);
            array[toIndex] = temp;
        }
    }

    public static <T> void move(char[] array, int fromIndex, int toIndex) {
        if (isOutOfIndex(array, fromIndex)) {
            return;
        }

        if (isOutOfIndex(array, toIndex)) {
            return;
        }

        if (fromIndex == toIndex) {
            return;
        }

        if (fromIndex > toIndex) {
            char temp = array[fromIndex];
            System.arraycopy(array, toIndex, array, toIndex + 1, fromIndex - toIndex);
            array[toIndex] = temp;
        } else {
            char temp = array[fromIndex];
            System.arraycopy(array, fromIndex + 1, array, fromIndex, toIndex - fromIndex);
            array[toIndex] = temp;
        }
    }

    public static <T> void move(int[] array, int fromIndex, int toIndex) {
        if (isOutOfIndex(array, fromIndex)) {
            return;
        }

        if (isOutOfIndex(array, toIndex)) {
            return;
        }

        if (fromIndex == toIndex) {
            return;
        }

        if (fromIndex > toIndex) {
            int temp = array[fromIndex];
            System.arraycopy(array, toIndex, array, toIndex + 1, fromIndex - toIndex);
            array[toIndex] = temp;
        } else {
            int temp = array[fromIndex];
            System.arraycopy(array, fromIndex + 1, array, fromIndex, toIndex - fromIndex);
            array[toIndex] = temp;
        }
    }

    public static <T> void move(long[] array, int fromIndex, int toIndex) {
        if (isOutOfIndex(array, fromIndex)) {
            return;
        }

        if (isOutOfIndex(array, toIndex)) {
            return;
        }

        if (fromIndex == toIndex) {
            return;
        }

        if (fromIndex > toIndex) {
            long temp = array[fromIndex];
            System.arraycopy(array, toIndex, array, toIndex + 1, fromIndex - toIndex);
            array[toIndex] = temp;
        } else {
            long temp = array[fromIndex];
            System.arraycopy(array, fromIndex + 1, array, fromIndex, toIndex - fromIndex);
            array[toIndex] = temp;
        }
    }

    public static <T> void move(float[] array, int fromIndex, int toIndex) {
        if (isOutOfIndex(array, fromIndex)) {
            return;
        }

        if (isOutOfIndex(array, toIndex)) {
            return;
        }

        if (fromIndex == toIndex) {
            return;
        }

        if (fromIndex > toIndex) {
            float temp = array[fromIndex];
            System.arraycopy(array, toIndex, array, toIndex + 1, fromIndex - toIndex);
            array[toIndex] = temp;
        } else {
            float temp = array[fromIndex];
            System.arraycopy(array, fromIndex + 1, array, fromIndex, toIndex - fromIndex);
            array[toIndex] = temp;
        }
    }

    public static <T> void move(double[] array, int fromIndex, int toIndex) {
        if (isOutOfIndex(array, fromIndex)) {
            return;
        }

        if (isOutOfIndex(array, toIndex)) {
            return;
        }

        if (fromIndex == toIndex) {
            return;
        }

        if (fromIndex > toIndex) {
            double temp = array[fromIndex];
            System.arraycopy(array, toIndex, array, toIndex + 1, fromIndex - toIndex);
            array[toIndex] = temp;
        } else {
            double temp = array[fromIndex];
            System.arraycopy(array, fromIndex + 1, array, fromIndex, toIndex - fromIndex);
            array[toIndex] = temp;
        }
    }

    public static <T> void distinct(Iterable<T> iterable) {
        distinct(iterable, false);
    }

    public static <T> void distinct(Iterable<T> collection, boolean keepNull) {
        if (isEmpty(collection)) {
            return;
        }
        HashSet<T> set = new HashSet<>();

        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (t == null && !keepNull) {
                iterator.remove();
            }
            if (set.contains(t)) {
                iterator.remove();
                continue;
            }
            set.add(t);
        }
    }

    public static <T, K> void distinct(Collection<T> collection, Mapper<T, K> mapper) {
        distinct(collection, false, mapper);
    }

    public static <T, K> void distinct(Collection<T> collection, boolean keepNull, Mapper<T, K> mapper) {
        if (isEmpty(collection)) {
            return;
        }
        HashSet<K> set = new HashSet<>();

        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            T t = iterator.next();
            K k = mapper.map(t);
            if (k == null && !keepNull) {
                iterator.remove();
            }
            if (set.contains(k)) {
                iterator.remove();
                continue;
            }
            set.add(k);
        }
    }


    public static <T> ArrayList<T> newDistinctList(Collection<T> collection) {
        return newDistinctList(collection, false);
    }

    public static <T> ArrayList<T> newDistinctList(Collection<T> collection, boolean keepNull) {
        ArrayList<T> list = new ArrayList<>();
        if (isEmpty(collection)) {
            return list;
        }

        HashSet<T> set = new HashSet<>();

        for (T t : collection) {
            if (t == null && !keepNull) {
                continue;
            }
            if (set.contains(t)) {
                continue;
            }
            set.add(t);
            list.add(t);
        }

        return list;
    }

    public static <T, K> ArrayList<T> newDistinctList(Collection<T> collection, Mapper<T, K> mapper) {
        return newDistinctList(collection, false, mapper);
    }

    public static <T, K> ArrayList<T> newDistinctList(Collection<T> collection, boolean keepNull, Mapper<T, K> mapper) {
        ArrayList<T> list = new ArrayList<>();
        if (isEmpty(collection)) {
            return list;
        }

        HashSet<K> set = new HashSet<>();

        for (T t : collection) {
            K key = mapper.map(t);
            if (key == null && !keepNull) {
                continue;
            }

            if (set.contains(key)) {
                continue;
            }

            set.add(key);
            list.add(t);
        }
        set.clear();
        return list;
    }

    public static <T> ArrayList<T> merge(Collection<T>... collections) {
        return merge(false, collections);
    }

    public static <T> ArrayList<T> merge(boolean keepNull, Collection<T>... collections) {
        ArrayList<T> list = new ArrayList<>();
        if (isEmpty(collections)) {
            return list;
        }
        HashSet<T> set = new HashSet<>();

        for (Collection<T> c : collections) {
            if (c == null) {
                continue;
            }
            for (T t : c) {
                if (t == null && !keepNull) {
                    continue;
                }
                if (set.contains(t)) {
                    continue;
                }
                list.add(t);
                set.add(t);
            }
        }
        return list;
    }

    public static <T, K> ArrayList<T> merge(Mapper<T, K> mapper, Collection<T>... collections) {
        return merge(mapper, false, collections);
    }

    public static <T, K> ArrayList<T> merge(Mapper<T, K> mapper, boolean keepNull, Collection<T>... collections) {
        return merge(collections, keepNull, mapper);
    }

    public static <T, K> ArrayList<T> merge(Collection<T>[] collections, Mapper<T, K> mapper) {
        return merge(collections, false, mapper);
    }

    public static <T, K> ArrayList<T> merge(Collection<T>[] collections, boolean keepNull, Mapper<T, K> mapper) {
        ArrayList<T> list = new ArrayList<>();
        if (isEmpty(collections)) {
            return list;
        }
        HashSet<K> set = new HashSet<>();

        for (Collection<T> c : collections) {
            if (c == null) {
                continue;
            }
            for (T t : c) {
                K k = mapper.map(t);
                if (k == null && !keepNull) {
                    continue;
                }
                if (set.contains(k)) {
                    continue;
                }
                list.add(t);
                set.add(k);
            }
        }
        return list;
    }

    public static <T> ArrayList<T> include(Collection<T> collection, Collection<T> target) {
        ArrayList<T> list = new ArrayList<>();
        if (isEmpty(collection)) {
            return list;
        }
        if (isEmpty(target)) {
            return list;
        }

        HashSet<T> set;
        if (target instanceof HashSet) {
            set = (HashSet<T>) target;
        } else {
            set = new HashSet<>(target);
        }

        for (T t : collection) {
            if (set.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }

    public static <T, K> ArrayList<T> include(Collection<T> collection, Collection<K> target, Mapper<T, K> mapper) {
        ArrayList<T> list = new ArrayList<>();
        if (isEmpty(collection)) {
            return list;
        }
        if (isEmpty(target)) {
            return list;
        }

        HashSet<K> set;
        if (target instanceof HashSet) {
            set = (HashSet<K>) target;
        } else {
            set = new HashSet<>(target);
        }

        for (T t : collection) {
            K k = mapper.map(t);
            if (set.contains(k)) {
                list.add(t);
            }
        }

        return list;
    }

    public static <T> ArrayList<T> exclude(Collection<T> collection, Collection<T> target) {
        ArrayList<T> list = new ArrayList<>();
        if (isEmpty(collection)) {
            return list;
        }
        if (isEmpty(target)) {
            list.addAll(collection);
            return list;
        }

        HashSet<T> set;
        if (target instanceof HashSet) {
            set = (HashSet<T>) target;
        } else {
            set = new HashSet<>(target);
        }

        for (T t : collection) {
            if (!set.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }

    public static <T, K> ArrayList<T> exclude(Collection<T> collection, Collection<K> target, Mapper<T, K> mapper) {
        ArrayList<T> list = new ArrayList<>();
        if (isEmpty(collection)) {
            return list;
        }
        if (isEmpty(target)) {
            list.addAll(collection);
            return list;
        }

        HashSet<K> set;
        if (target instanceof HashSet) {
            set = (HashSet<K>) target;
        } else {
            set = new HashSet<>(target);
        }

        for (T t : collection) {
            K k = mapper.map(t);
            if (!set.contains(k)) {
                list.add(t);
            }
        }

        return list;
    }

    public static <T> void forEach(Iterable<T> iterable, IndexProcessor<T> indexProcessor) {
        if (isEmpty(iterable)) {
            return;
        }

        int index = 0;
        for (T t : iterable) {
            indexProcessor.process(index, t);
            index++;
        }
    }

    public static <T> void forEach(T[] array, IndexProcessor<T> indexProcessor) {
        if (isEmpty(array)) {
            return;
        }
        int index = 0;
        for (T t : array) {
            indexProcessor.process(index, t);
            index++;
        }
    }

    public static <T> void reverseTraverse(Iterable<T> iterable, IndexProcessor<T> indexProcessor) {
        if (isEmpty(iterable)) {
            return;
        }

        if (iterable instanceof List) {
            //noinspection rawtypes
            reverseTraverse((List) iterable, indexProcessor);
        } else {
            reverseTraverse(toArray(iterable), indexProcessor);
        }
    }

    public static <T> void reverseTraverse(T[] array, IndexProcessor<T> indexProcessor) {
        if (isEmpty(array)) {
            return;
        }

        for (int index = array.length - 1; index >= 0; index--) {
            indexProcessor.process(index, array[index]);
        }
    }

    public static <T> void reverseTraverse(List<T> list, IndexProcessor<T> indexProcessor) {
        if (isEmpty(list)) {
            return;
        }

        for (int index = list.size() - 1; index >= 0; index--) {
            indexProcessor.process(index, list.get(index));
        }
    }

    public static <T, K> HashSet<K> extractSet(Collection<T> collection, Mapper<T, K> mapper) {
        return extractSet(collection, false, mapper);
    }

    public static <T, K> HashSet<K> extractSet(Collection<T> collection, boolean keepNull, Mapper<T, K> mapper) {
        HashSet<K> set = new HashSet<>();

        if (isEmpty(collection)) {
            return set;
        }

        for (T t : collection) {
            K key = mapper.map(t);
            if (key == null && !keepNull) {
                continue;
            }

            set.add(key);
        }

        return set;
    }

    public static <T, K> ArrayList<K> extractList(Collection<T> collection, Mapper<T, K> mapper) {
        return extractList(collection, false, mapper);
    }

    public static <T, K> ArrayList<K> extractList(Collection<T> collection, boolean keepNull, Mapper<T, K> mapper) {
        ArrayList<K> list = new ArrayList<>();

        if (isEmpty(collection)) {
            return list;
        }

        for (T t : collection) {
            K key = mapper.map(t);
            if (key == null && !keepNull) {
                continue;
            }

            list.add(key);
        }

        return list;
    }

    public static <T> IntRange getSizeRange(T[][] arrays) {
        boolean initialized = false;
        int min = 0;
        int max = 0;


        for (T[] array : arrays) {
            int length = size(array);
            if (initialized) {
                min = Math.min(length, min);
                max = Math.max(length, max);
            } else {
                min = length;
                max = length;
                initialized = true;
            }
        }

        if (!initialized) {
            throw new IllegalStateException("no array found");
        }

        return new IntRange(min, max);
    }

    public static <T> int getMinSize(T[][] arrays) {
        return getSizeRange(arrays).getStart();
    }

    public static <T> int getMaxSize(T[][] arrays) {
        return getSizeRange(arrays).getEnd();
    }

    public static <T> ArrayList<T> clone(Iterable<T> src, Mapper<T, T> mapper) {
        ArrayList<T> cloneList = new ArrayList<>();

        if (src == null) {
            return cloneList;
        }

        for (T t : src) {
            T clone = mapper.map(t);
            cloneList.add(clone);
        }

        return cloneList;
    }

    // ================================================//

    public static IntRange getIntValuesRange(Iterable<int[]> values) {
        IntRange range = null;
        if (isEmpty(values)) {
            return null;
        }

        for (int[] valueArray : values) {
            if (valueArray == null || valueArray.length == 0) {
                continue;
            }
            for (int value : valueArray) {
                if (range == null) {
                    range = new IntRange(value, value);
                } else {
                    if (value < range.getStart()) {
                        range.setStart(value);
                    }
                    if (value > range.getEnd()) {
                        range.setEnd(value);
                    }
                }
            }
        }
        return range;
    }

    public static LongRange getLongValuesRange(Iterable<long[]> values) {
        LongRange range = null;
        if (isEmpty(values)) {
            return null;
        }

        for (long[] valueArray : values) {
            if (valueArray == null || valueArray.length == 0) {
                continue;
            }
            for (long value : valueArray) {
                if (range == null) {
                    range = new LongRange(value, value);
                } else {
                    if (value < range.getStart()) {
                        range.setStart(value);
                    }
                    if (value > range.getEnd()) {
                        range.setEnd(value);
                    }
                }
            }
        }
        return range;
    }

    public static DoubleRange getDoubleValuesRange(Iterable<double[]> values) {
        DoubleRange range = null;
        if (isEmpty(values)) {
            return null;
        }

        for (double[] valueArray : values) {
            if (valueArray == null || valueArray.length == 0) {
                continue;
            }
            for (double value : valueArray) {
                if (Double.isNaN(value)) {
                    continue;
                }
                if (range == null) {
                    range = new DoubleRange(value, value);
                } else {
                    if (value < range.getStart()) {
                        range.setStart(value);
                    }
                    if (value > range.getEnd()) {
                        range.setEnd(value);
                    }
                }
            }
        }
        return range;
    }

    // ================================================= //


    // ============================== //

    public static IntRange getRangeOfIntSeries(IntSeries series) {
        IntRange range = null;

        if (series == null) {
            return null;
        }
        int length = series.length();
        if (length == 0) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            int value = series.get(i);
            if (range == null) {
                range = new IntRange(value, value);
            } else {
                if (value < range.getStart()) {
                    range.setStart(value);
                }
                if (value > range.getEnd()) {
                    range.setEnd(value);
                }
            }
        }
        return range;
    }

    public static LongRange getRangeOfLongSeries(LongSeries series) {
        LongRange range = null;

        if (series == null) {
            return null;
        }
        int length = series.length();
        if (length == 0) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            long value = series.get(i);
            if (range == null) {
                range = new LongRange(value, value);
            } else {
                if (value < range.getStart()) {
                    range.setStart(value);
                }
                if (value > range.getEnd()) {
                    range.setEnd(value);
                }
            }
        }
        return range;
    }

    public static DoubleRange getRangeOfDoubleSeries(DoubleSeries series) {
        DoubleRange range = null;

        if (series == null) {
            return null;
        }
        int length = series.length();
        if (length == 0) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            double value = series.get(i);
            if (Double.isNaN(value)) {
                continue;
            }
            if (range == null) {
                range = new DoubleRange(value, value);
            } else {
                if (value < range.getStart()) {
                    range.setStart(value);
                }
                if (value > range.getEnd()) {
                    range.setEnd(value);
                }
            }
        }
        return range;
    }

    // =============================== //
    // =========================================//

    public static IntRange getRangeOfIntSeriesList(Iterable<? extends IntSeries> seriesList) {
        IntRange range = null;
        if (isEmpty(seriesList)) {
            return null;
        }

        for (IntSeries series : seriesList) {
            if (series == null) {
                continue;
            }
            int length = series.length();
            if (length == 0) {
                continue;
            }
            for (int i = 0; i < length; i++) {
                int value = series.get(i);
                if (range == null) {
                    range = new IntRange(value, value);
                } else {
                    if (value < range.getStart()) {
                        range.setStart(value);
                    }
                    if (value > range.getEnd()) {
                        range.setEnd(value);
                    }
                }
            }
        }
        return range;
    }

    public static LongRange getRangeOfLongSeriesList(Iterable<? extends LongSeries> seriesList) {
        LongRange range = null;
        if (isEmpty(seriesList)) {
            return null;
        }

        for (LongSeries series : seriesList) {
            if (series == null) {
                continue;
            }
            int length = series.length();
            if (length == 0) {
                continue;
            }
            for (int i = 0; i < length; i++) {
                long value = series.get(i);
                if (range == null) {
                    range = new LongRange(value, value);
                } else {
                    if (value < range.getStart()) {
                        range.setStart(value);
                    }
                    if (value > range.getEnd()) {
                        range.setEnd(value);
                    }
                }
            }
        }
        return range;
    }

    public static DoubleRange getRangeOfDoubleSeriesList(Iterable<? extends DoubleSeries> seriesList) {
        DoubleRange range = null;
        if (isEmpty(seriesList)) {
            return null;
        }

        for (DoubleSeries series : seriesList) {
            if (series == null) {
                continue;
            }
            int length = series.length();
            if (length == 0) {
                continue;
            }
            for (int i = 0; i < length; i++) {
                double value = series.get(i);
                if (range == null) {
                    range = new DoubleRange(value, value);
                } else {
                    if (value < range.getStart()) {
                        range.setStart(value);
                    }
                    if (value > range.getEnd()) {
                        range.setEnd(value);
                    }
                }
            }
        }
        return range;
    }

    // =====================================================//

    public static int compare(boolean x, boolean y) {
        return Boolean.compare(x, y);
    }

    public static int compare(byte x, byte y) {
        return Byte.compare(x, y);
    }

    public static int compare(char x, char y) {
        return Character.compare(x, y);
    }

    public static int compare(int x, int y) {
        return Integer.compare(x, y);
    }

    public static int compare(long x, long y) {
        return Long.compare(x, y);
    }

    public static int compare(float x, float y) {
        return Float.compare(x, y);
    }

    public static int compare(double x, double y) {
        return Double.compare(x, y);
    }

    public static <K, V> List<Map.Entry<K, V>> getEntryList(Map<K, V> map) {
        if (isEmpty(map)) {
            return Collections.emptyList();
        }

        Set<Map.Entry<K, V>> entrySet = map.entrySet();
        if (isEmpty(entrySet)) {
            return Collections.emptyList();
        }
        return new ArrayList<>(entrySet);
    }

    public static <T, E> List<E> convert(Iterable<? extends T> srcList, IndexMapper<T, E> mapper) {
        if (isEmpty(srcList)) {
            return Collections.emptyList();
        }
        ArrayList<E> dstList = new ArrayList<>();
        int i = 0;
        for (T t : srcList) {
            dstList.add(mapper.map(i, t));
            i++;
        }
        return dstList;
    }

    public static <T, E> List<E> convert(T[] array, IndexMapper<T, E> mapper) {
        if (isEmpty(array)) {
            return Collections.emptyList();
        }
        ArrayList<E> dstList = new ArrayList<>();
        int i = 0;
        for (T t : array) {
            dstList.add(mapper.map(i, t));
            i++;
        }

        return dstList;
    }

    public static <T> int[] convert(Iterable<? extends T> iterable, IndexIntMapper<T> mapper) {
        if (isEmpty(iterable)) {
            return EMPTY_INT_ARRAY;
        }

        int size = size(iterable);
        int i = 0;
        int[] values = new int[size];
        for (T t : iterable) {
            values[i] = mapper.map(i, t);
            i++;
        }

        return values;
    }

    public static <T> int[] convert(T[] array, IndexIntMapper<T> mapper) {
        if (isEmpty(array)) {
            return EMPTY_INT_ARRAY;
        }
        int size = array.length;
        int i = 0;
        int[] values = new int[size];
        for (T t : array) {
            values[i] = mapper.map(i, t);
            i++;
        }

        return values;
    }

    public static <T> long[] convert(Iterable<? extends T> iterable, IndexLongMapper<T> mapper) {
        if (isEmpty(iterable)) {
            return EMPTY_LONG_ARRAY;
        }

        int size = size(iterable);
        int i = 0;
        long[] values = new long[size];
        for (T t : iterable) {
            values[i] = mapper.map(i, t);
            i++;
        }

        return values;
    }

    public static <T> long[] convert(T[] array, IndexLongMapper<T> mapper) {
        if (isEmpty(array)) {
            return EMPTY_LONG_ARRAY;
        }
        int size = array.length;
        int i = 0;
        long[] values = new long[size];
        for (T t : array) {
            values[i] = mapper.map(i, t);
            i++;
        }

        return values;
    }

    public static <T> double[] convert(Iterable<? extends T> iterable, IndexDoubleMapper<T> mapper) {
        if (isEmpty(iterable)) {
            return EMPTY_DOUBLE_ARRAY;
        }

        int size = size(iterable);
        int i = 0;
        double[] values = new double[size];
        for (T t : iterable) {
            values[i] = mapper.map(i, t);
            i++;
        }

        return values;
    }

    public static <T> double[] convert(T[] array, IndexDoubleMapper<T> mapper) {
        if (isEmpty(array)) {
            return EMPTY_DOUBLE_ARRAY;
        }
        int size = array.length;
        int i = 0;
        double[] values = new double[size];
        for (T t : array) {
            values[i] = mapper.map(i, t);
            i++;
        }

        return values;
    }

    public static <T, E> void convert(T[] srcArray, E[] dstArray, IndexMapper<T, E> mapper) {
        if (isEmpty(srcArray) || isEmpty(dstArray)) {
            return;
        }

        for (int i = 0, size = Math.min(srcArray.length, dstArray.length); i < size; i++) {
            T t = srcArray[i];
            dstArray[i] = mapper.map(i, t);
        }
    }

    public static <T, E> List<E> convert(Iterable<? extends T> srcList, Mapper<T, E> mapper) {
        if (isEmpty(srcList)) {
            return Collections.emptyList();
        }
        ArrayList<E> dstList = new ArrayList<>();
        int i = 0;
        for (T t : srcList) {
            dstList.add(mapper.map(t));
            i++;
        }
        return dstList;
    }

    public static <T, E> List<E> convert(T[] array, Mapper<T, E> mapper) {
        if (isEmpty(array)) {
            return Collections.emptyList();
        }
        ArrayList<E> dstList = new ArrayList<>();
        int i = 0;
        for (T t : array) {
            dstList.add(mapper.map(t));
            i++;
        }

        return dstList;
    }

    public static <T> int[] convert(Iterable<? extends T> iterable, IntMapper<T> mapper) {
        if (isEmpty(iterable)) {
            return EMPTY_INT_ARRAY;
        }

        int size = size(iterable);
        int i = 0;
        int[] values = new int[size];
        for (T t : iterable) {
            values[i] = mapper.map(t);
            i++;
        }

        return values;
    }

    public static <T> int[] convert(T[] array, IntMapper<T> mapper) {
        if (isEmpty(array)) {
            return EMPTY_INT_ARRAY;
        }
        int i = 0;
        int[] values = new int[array.length];
        for (T t : array) {
            values[i] = mapper.map(t);
            i++;
        }

        return values;
    }

    public static <T> long[] convert(Iterable<? extends T> iterable, LongMapper<T> mapper) {
        if (isEmpty(iterable)) {
            return EMPTY_LONG_ARRAY;
        }

        int size = size(iterable);
        int i = 0;
        long[] values = new long[size];
        for (T t : iterable) {
            values[i] = mapper.map(t);
            i++;
        }

        return values;
    }

    public static <T> long[] convert(T[] array, LongMapper<T> mapper) {
        if (isEmpty(array)) {
            return EMPTY_LONG_ARRAY;
        }
        int size = array.length;
        int i = 0;
        long[] values = new long[size];
        for (T t : array) {
            values[i] = mapper.map(t);
            i++;
        }

        return values;
    }

    public static <T> double[] convert(Iterable<? extends T> iterable, DoubleMapper<T> mapper) {
        if (isEmpty(iterable)) {
            return EMPTY_DOUBLE_ARRAY;
        }

        int size = size(iterable);
        int i = 0;
        double[] values = new double[size];
        for (T t : iterable) {
            values[i] = mapper.map(t);
            i++;
        }

        return values;
    }

    public static <T> double[] convert(T[] array, DoubleMapper<T> mapper) {
        if (isEmpty(array)) {
            return EMPTY_DOUBLE_ARRAY;
        }
        int size = array.length;
        int i = 0;
        double[] values = new double[size];
        for (T t : array) {
            values[i] = mapper.map(t);
            i++;
        }

        return values;
    }

    // =================================== //

    public static <T, E> void convert(T[] srcArray, E[] dstArray, Mapper<T, E> mapper) {
        if (isEmpty(srcArray) || isEmpty(dstArray)) {
            return;
        }

        for (int i = 0, size = Math.min(srcArray.length, dstArray.length); i < size; i++) {
            T t = srcArray[i];
            dstArray[i] = mapper.map(t);
        }
    }


    public static <T> T[] concat(T[]... arrays) {
        SearchResult<T> result = find(arrays, new Matcher<T>() {
            @Override
            public boolean isMatch(T t) {
                return t != null;
            }
        });

        if (result == null) {
            return null;
        }
        Class<T> cls = (Class<T>) result.getResult().getClass();

        return concat(cls, arrays);
    }

    public static <T> T[] concat(Class<T> cls, T[]... arrays) {
        int size = size(arrays);
        if (size == 0) {
            return (T[]) java.lang.reflect.Array.newInstance(cls, 0);
        }


        int length = 0;

        for (T[] other : arrays) {
            length += size(other);
        }

        T[] result = (T[]) java.lang.reflect.Array.newInstance(cls, length);
        int index = 0;

        for (T[] array : arrays) {
            if (isEmpty(array)) {
                continue;
            }
            System.arraycopy(array, 0, result, index, array.length);
            index += array.length;
        }

        return result;
    }

    public static <T> boolean contains(T[] container, T[] elements) {
        if (isEmpty(elements)) {
            return true;
        }
        if (isEmpty(container)) {
            return false;
        }
        for (int i = 0, elementSize = size(elements); i < elementSize; i++) {
            T element = elements[i];
            if (!contains(container, element)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean contains(T[] container, T element) {
        if (isEmpty(container)) {
            return false;
        }
        for (int i = 0, size = size(container); i < size; i++) {
            T t = container[i];
            if (t == null) {
                if (element == null) {
                    return true;
                } else {
                    continue;
                }
            }
            if (t.equals(element)) {
                return true;
            }
        }

        return false;
    }

    public static boolean contains(int[] container, int element) {
        if (isEmpty(container)) {
            return false;
        }

        for (int i = 0, size = size(container); i < size; i++) {
            int t = container[i];
            if (t == element) {
                return true;
            }
        }

        return false;
    }

    public static <T> List<T> listOf(T... array) {
        if (isEmpty(array)) {
            return new ArrayList<>();
        }

        return Arrays.asList(array);
    }

    public static <T> T[] arrayOf(T... array) {
        return array;
    }

    public static <T> List<T> toList(T[] array) {
        return array == null ? new ArrayList<T>() : Arrays.asList(array);
    }

    public static <T> T[] toArray(Iterable<T> iterable) {
        T t = find(iterable, new Matcher<T>() {
            @Override
            public boolean isMatch(T t) {
                return t != null;
            }
        });
        if (t == null) {
            return null;
        }
        return toArray(iterable, (Class<T>) t.getClass());
    }

    public static <T> T[] toArray(Iterable<T> iterable, Class<T> cls) {
        int size = size(iterable);
        T[] array = (T[]) java.lang.reflect.Array.newInstance(cls, size);
        if (size == 0) {
            return array;
        }

        if (iterable instanceof List) {
            return ((List<T>) iterable).toArray(array);
        }

        int index = -1;
        for (T t : iterable) {
            index++;
            array[index] = t;
        }

        return array;
    }

    public static <T, R> R[] toArray(Iterable<T> iterable, Class<R> cls, Mapper<T, R> mapper) {
        int size = size(iterable);
        R[] array = (R[]) java.lang.reflect.Array.newInstance(cls, size);
        return toArray(iterable, size, array, mapper);
    }

    public static <T, R> R[] toArray(Iterable<T> iterable, R[] array, Mapper<T, R> mapper) {
        int size = size(iterable);
        int arraySize = size(array);
        return toArray(iterable, size, array, mapper);
    }

    private static <T, R> R[] toArray(Iterable<T> iterable, int size, R[] array, Mapper<T, R> mapper) {
        if (size == 0) {
            return array;
        }
        int index = 0;
        for (T t : iterable) {
            array[index] = mapper.map(t);
            ++index;
        }

        return array;
    }

    public static <T, R> R[] toArray(Iterable<T> iterable, Class<R> cls, IndexMapper<T, R> mapper) {
        int size = size(iterable);
        R[] array = (R[]) java.lang.reflect.Array.newInstance(cls, size);
        return toArray(iterable, size, array, mapper);
    }

    public static <T, R> R[] toArray(Iterable<T> iterable, R[] array, IndexMapper<T, R> mapper) {
        int size = size(iterable);
        int arraySize = size(array);
        return toArray(iterable, size, array, mapper);
    }

    private static <T, R> R[] toArray(Iterable<T> iterable, int size, R[] array, IndexMapper<T, R> mapper) {
        if (size == 0) {
            return array;
        }
        int index = 0;
        for (T t : iterable) {
            array[index] = mapper.map(index, t);
            ++index;
        }

        return array;
    }

    public static IntRange[] splitToRanges(int from, int to, int rangeSize) {
        if (rangeSize <= 0) {
            throw new IllegalArgumentException();
        }
        if (from == to) {
            return new IntRange[]{new IntRange(from, to)};
        } else if (from < to) {
            int rangeCount = getRangeCount(from, to, rangeSize);
            IntRange[] ranges = new IntRange[rangeCount];
            for (int i = 0; i < rangeCount; i++) {
                ranges[i] = new IntRange(from + i * rangeSize, Math.min(from + (i + 1) * rangeSize - 1, to));
            }
            return ranges;
        } else {
            int rangeCount = getRangeCount(from, to, rangeSize);
            IntRange[] ranges = new IntRange[rangeCount];
            for (int i = 0; i < rangeCount; i++) {
                ranges[i] = new IntRange(from - i * rangeSize, Math.max(from - (i + 1) * rangeSize + 1, to));
            }
            return ranges;
        }
    }

    public static int getRangeCount(int from, int to, int rangeSize) {
        if (rangeSize <= 0) {
            throw new IllegalArgumentException();
        }
        if (from == to) {
            return 1;
        }

        int range = Math.abs(to - from) + 1;
        int rangeCount = range / rangeSize;
        if (range % rangeSize != 0) {
            rangeCount++;
        }
        return rangeCount;
    }

    public static IntRange getRange(int form, int to, int rangeSize, int rangeIndex) {
        return splitToRanges(form, to, rangeSize)[rangeIndex];
    }

    public static <T> List<T> newReversed(Iterable<T> source) {
        if (isEmpty(source)) {
            return Collections.emptyList();
        }

        List<T> target;
        if (source instanceof Collection) {
            Collection<T> c = (Collection<T>) source;
            target = new ArrayList<>(c);
            if (target.size() == 1) {
                return target;
            }
            Collections.reverse(target);
        } else {
            int size = size(source);
            Array<T> array = new Array<>(size);

            int index = 0;
            for (T t : source) {
                array.set(size - 1 - index, t);
                index++;
            }

            target = array.toList();
        }

        return target;
    }

    public static <E> int remove(List<E> list, int index, int range) {
        if (isEmpty(list)) {
            return 0;
        }

        if (list instanceof RandomAccess) {
            int removedCount = 0;
            int lastIndex = index + range - 1;
            for (int i = 0; i < range; i++) {
                list.remove(lastIndex - i);
                removedCount++;
            }
            return removedCount;
        } else {
            return remove((Iterable<E>) list, index, range);
        }
    }

    public static <E> int remove(Iterable<E> iterable, int index, int range) {
        if (isEmpty(iterable)) {
            return 0;
        }

        int removedCount = 0;


        int i = 0;
        Iterator<E> iterator = iterable.iterator();
        while (i < index && iterator.hasNext()) {
            iterator.next();
            i++;
        }

        if (i < index) {
            return removedCount;
        }

        i = 0;
        while (i < range && iterator.hasNext()) {
            iterator.next();
            iterator.remove();
            removedCount++;
            i++;
        }

        return removedCount;
    }

    public static <T> int remove(Iterable<T> iterable, Matcher<T> matcher) {
        return remove(iterable, 0, matcher);
    }

    public static <T> int remove(Iterable<T> iterable, int startIndex, Matcher<T> matcher) {
        if (isOutOfIndex(iterable, startIndex)) {
            return 0;
        }

        int removeCount = 0;
        int index = 0;
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (index >= startIndex && matcher.isMatch(t)) {
                iterator.remove();
                removeCount++;
            }
            ++index;
        }
        return removeCount;
    }

    public static <T> IntRange intMinMax(int[] values) {
        if (values == null) {
            return null;
        }

        IntRange intRange = new IntRange(values[0], values[0]);

        for (int i = 1, length = values.length; i < length; i++) {
            int value = values[i];
            if (value < intRange.getStart()) {
                intRange.setStart(value);
            }
            if (value > intRange.getEnd()) {
                intRange.setEnd(value);
            }
        }

        return intRange;
    }

    public static <T> LongRange longMinMax(long[] values) {
        if (values == null) {
            return null;
        }

        LongRange longRange = new LongRange(values[0], values[0]);

        for (int i = 1, length = values.length; i < length; i++) {
            long value = values[i];
            if (value < longRange.getStart()) {
                longRange.setStart(value);
            }
            if (value > longRange.getEnd()) {
                longRange.setEnd(value);
            }
        }

        return longRange;
    }

    public static <T> DoubleRange doubleMinMax(double[] values) {
        if (values == null) {
            return null;
        }

        DoubleRange doubleRange = new DoubleRange(values[0], values[0]);

        for (int i = 1, length = values.length; i < length; i++) {
            double value = values[i];
            if (value < doubleRange.getStart()) {
                doubleRange.setStart(value);
            }
            if (value > doubleRange.getEnd()) {
                doubleRange.setEnd(value);
            }
        }

        return doubleRange;
    }

    // ================================= //

    public static <T> IntRange intMinMax(Iterable<T> iterable, IntMapper<T> mapper) {
        if (iterable == null) {
            return null;
        }
        IntRange intRange = null;
        int index = 0;
        for (T t : iterable) {
            int value = mapper.map(t);
            if (index == 0) {
                intRange = new IntRange(value, value);
            } else {
                if (value < intRange.getStart()) {
                    intRange.setStart(value);
                }
                if (value > intRange.getEnd()) {
                    intRange.setEnd(value);
                }
            }

            index++;
        }

        return intRange;
    }

    public static <T> LongRange longMinMax(Iterable<T> iterable, LongMapper<T> mapper) {
        if (iterable == null) {
            return null;
        }
        LongRange intRange = null;
        int index = 0;
        for (T t : iterable) {
            long value = mapper.map(t);
            if (index == 0) {
                intRange = new LongRange(value, value);
            } else {
                if (value < intRange.getStart()) {
                    intRange.setStart(value);
                }
                if (value > intRange.getEnd()) {
                    intRange.setEnd(value);
                }
            }

            index++;
        }

        return intRange;
    }

    public static <T> DoubleRange doubleMinMax(Iterable<T> iterable, DoubleMapper<T> mapper) {
        if (iterable == null) {
            return null;
        }
        DoubleRange doubleRange = null;
        int index = 0;
        for (T t : iterable) {
            double value = mapper.map(t);
            if (index == 0) {
                doubleRange = new DoubleRange(value, value);
            } else {
                if (value < doubleRange.getStart()) {
                    doubleRange.setStart(value);
                }
                if (value > doubleRange.getEnd()) {
                    doubleRange.setEnd(value);
                }
            }

            index++;
        }

        return doubleRange;
    }

    // ============================ //

    public static <T> IntRange intMinMax(Iterable<T> iterable, IntMapper<T> minMapper, IntMapper<T> maxMapper) {
        if (iterable == null) {
            return null;
        }
        IntRange intRange = null;
        int index = 0;
        for (T t : iterable) {
            int min = minMapper.map(t);
            int max = maxMapper.map(t);

            if (index == 0) {
                intRange = new IntRange(min, max);
            } else {
                if (min < intRange.getStart()) {
                    intRange.setStart(min);
                }
                if (max > intRange.getEnd()) {
                    intRange.setEnd(max);
                }
            }

            index++;
        }

        return intRange;
    }

    public static <T> LongRange longMinMax(Iterable<T> iterable, LongMapper<T> minMapper, LongMapper<T> maxMapper) {
        if (iterable == null) {
            return null;
        }
        LongRange intRange = null;
        int index = 0;
        for (T t : iterable) {
            long min = minMapper.map(t);
            long max = maxMapper.map(t);

            if (index == 0) {
                intRange = new LongRange(min, max);
            } else {
                if (min < intRange.getStart()) {
                    intRange.setStart(min);
                }
                if (max > intRange.getEnd()) {
                    intRange.setEnd(max);
                }
            }

            index++;
        }

        return intRange;
    }

    public static <T> DoubleRange doubleMinMax(Iterable<T> iterable, DoubleMapper<T> minMapper, DoubleMapper<T> maxMapper) {
        if (iterable == null) {
            return null;
        }
        DoubleRange doubleRange = null;
        int index = 0;
        for (T t : iterable) {
            double min = minMapper.map(t);
            double max = maxMapper.map(t);

            if (index == 0) {
                doubleRange = new DoubleRange(min, max);
            } else {
                if (min < doubleRange.getStart()) {
                    doubleRange.setStart(min);
                }
                if (max > doubleRange.getEnd()) {
                    doubleRange.setEnd(max);
                }
            }

            index++;
        }

        return doubleRange;
    }


    /**
     * 将逻辑上具有树形结构关系的list组装为树形list
     *
     * @param all        原本只是逻辑上具有树形结构关系，但是数据上只是普通列表的list对象
     * @param root       树形结构的根节点，本身不会添加到返回结果中，可以根据条件自行创建
     * @param predicate  判断两个对象是否是逻辑上的父子节点，test(T t, U u); t是子节点，u是父节点就返回 true
     * @param comparator 节点排序，null则不排序
     * @param consumer   将children添加到 node 中，根据具体node的类型自行实现
     * @param <T>        node的数据类型
     * @return 树形结构的list
     */
    public static <T> List<T> listAsTree(List<T> all, T root, BiPredicate<T, T> predicate, Comparator<T> comparator, BiConsumer<T, List<T>> consumer) {
        List<T> tree = filterAndDelete(all, root, predicate, comparator);
        Queue<T> queue = new LinkedList<>(tree);
        while (!queue.isEmpty()) {
            T entity = queue.poll();
            List<T> children = filterAndDelete(all, entity, predicate, comparator);
            consumer.accept(entity, children);
            queue.addAll(children);
        }
        return tree;
    }

    private static <T> List<T> filterAndDelete(Iterable<T> all, T node, BiPredicate<T, T> predicate, Comparator<T> comparator) {
        List<T> children = null;
        Iterator<T> iterator = all.iterator();
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (predicate.test(t, node)) {
                if (children == null) {
                    children = new ArrayList<>();
                }
                children.add(t);
                iterator.remove();
            }
        }
        if (children == null) {
            return Collections.emptyList();
        } else {
            if (comparator != null) {
                children.sort(comparator);
            }
            return children;
        }
    }

    public static <T> List<T> filterAndDelete(Iterable<T> all, Predicate<T> predicate) {
        List<T> children = null;
        Iterator<T> iterator = all.iterator();
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (predicate.test(t)) {
                if (children == null) {
                    children = new ArrayList<>();
                }
                children.add(t);
                iterator.remove();
            }
        }
        return Objects.requireNonNullElse(children, Collections.emptyList());
    }
}