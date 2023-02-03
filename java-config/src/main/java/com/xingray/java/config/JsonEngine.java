package com.xingray.java.config;

public interface JsonEngine {
    
    <T> T fromJson(String json, Class<T> cls);

    <T> String toJson(T t);
}
