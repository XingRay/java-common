package com.xingray.java.collection.collection;

import java.util.List;
import java.util.Map;

public class Collections {

    public static <K, V> Collection<K, V> ofMap(Map<K, V> map){
        return new MapCollection<>(map);
    }

    public static <T> Collection<Integer, T> ofList(List<T> list){
        return new ListCollection<>(list);
    }

    public static <T> Collection<Integer, T> ofArray(T[] array){
        return new ArrayCollection<>(array);
    }
}
