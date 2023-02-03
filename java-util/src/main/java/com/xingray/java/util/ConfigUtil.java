package com.xingray.java.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigUtil {

    public static Map<String, String> loadConfig(String path) {
        Properties properties = loadProperties(path);
        return propertiesToStringMap(properties);
    }

    public static void saveConfig(String path, Map<String, String> config) {
        Properties properties = mapToProperties(config);
        saveProperties(path, properties);
    }

    public static Properties loadProperties(String path) {
        Properties properties = new Properties();
        if (!FileUtil.isFileExist(path)) {
            return properties;
        }

        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

    public static void saveProperties(String path, Properties properties) {
        if (properties == null) {
            return;
        }
        FileUtil.createFileIfNotExist(path);

        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            properties.store(fileOutputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String path, String key) {
        return loadProperties(path).getProperty(key);
    }

    public static void putProperty(String path, String key, String value) {
        Properties properties = loadProperties(path);
        properties.put(key, value);
        saveProperties(path, properties);
    }

    public static <T> T readFromProperties(String path, Class<T> cls) {
        Properties properties = loadProperties(path);
        Map<String, Object> map = propertiesToMap(properties);
        return ObjectUtil.mapToObject(map, cls);
    }

    public static <T> void writeToProperties(String path, T t) {
        Map<String, Object> map = ObjectUtil.objectToMap(t);
        Properties properties = mapToProperties(map);
        saveProperties(path, properties);
    }

    public static <T> T populateFromProperties(String path, T t) {
        if (t == null) {
            return null;
        }
        Properties properties = loadProperties(path);
        Map<String, Object> map = propertiesToMap(properties);
        return ObjectUtil.populateObject(t, map);
    }

    public static Map<String, Object> propertiesToMap(Properties properties) {
        if (properties == null || properties.isEmpty()) {
            return null;
        }

        Map<String, Object> map = new HashMap<>(properties.size());
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            map.put(key.toString(), value);
        }
        return map;
    }

    public static Map<String, String> propertiesToStringMap(Properties properties) {
        if (properties == null || properties.isEmpty()) {
            return null;
        }

        Map<String, String> map = new HashMap<>(properties.size());
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                key = "";
            }
            Object value = entry.getValue();
            if (value == null) {
                value = "";
            }
            map.put(key.toString(), value.toString());
        }
        return map;
    }

    public static Properties mapToProperties(Map<?, ?> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Properties properties = new Properties(map.size());
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            properties.put(StringUtil.toString(key), StringUtil.toString(value, ""));
        }
        return properties;
    }
}
