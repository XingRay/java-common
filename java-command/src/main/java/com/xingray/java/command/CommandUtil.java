package com.xingray.java.command;



import com.xingray.java.command.annotations.Command;
import com.xingray.java.command.annotations.KeyValueLinker;
import com.xingray.java.command.annotations.ListValueSeparator;
import com.xingray.java.command.annotations.NoCommandKey;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CommandUtil {
    public static String[] splitCmd(String command) {
        if (command.isEmpty())
            throw new IllegalArgumentException("Empty command");

        StringTokenizer st = new StringTokenizer(command);
        String[] cmdArray = new String[st.countTokens()];
        for (int i = 0; st.hasMoreTokens(); i++) {
            cmdArray[i] = st.nextToken();
        }

        return cmdArray;
    }

    public static String commandToString(Object command) throws IllegalAccessException {
        Command executorAnnotation = command.getClass().getAnnotation(Command.class);
        if (executorAnnotation == null) {
            throw new IllegalArgumentException("command must have annotation @Executor");
        }
        String executor = executorAnnotation.value();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(executor).append(' ');

        Field[] fields = command.getClass().getDeclaredFields();
        if (fields.length == 0) {
            return stringBuilder.toString();
        }
        for (Field field : fields) {
            // todo get field value by getter
            field.setAccessible(true);
            Object value = field.get(command);
            if (value == null) {
                continue;
            }

            NoCommandKey noCommandKeyAnnotation = field.getAnnotation(NoCommandKey.class);

            Class<?> fieldType = field.getType();
            if (fieldType == Boolean.class) {
                if ((Boolean) value) {
                    appendCommandKey(stringBuilder, field.getName());
                }
            } else if (fieldType == Integer.class) {
                appendCommandKey(stringBuilder, field.getName());
                stringBuilder.append('=').append(value);
            } else if (fieldType == String.class) {
                if (noCommandKeyAnnotation == null) {
                    appendCommandKey(stringBuilder, field.getName());
                    stringBuilder.append('=');
                }
                stringBuilder.append(value);
            } else if (fieldType == List.class) {
                List list = (List) value;
                if (list.isEmpty()) {
                    continue;
                }
                if (noCommandKeyAnnotation == null) {
                    appendCommandKey(stringBuilder, field.getName());
                    stringBuilder.append("=");
                }
                int index = 0;
                for (Object e : list) {
                    if (index > 0) {
                        stringBuilder.append(File.pathSeparatorChar);
                    }
                    stringBuilder.append(e.toString());
                    index++;
                }
            }
            stringBuilder.append(' ');
        }

        return stringBuilder.toString();
    }

    public static List<String> commandToStringList(Object command) throws IllegalAccessException {
        Class<?> commandClass = command.getClass();
        Command executorAnnotation = commandClass.getAnnotation(Command.class);
        if (executorAnnotation == null) {
            throw new IllegalArgumentException("command must have annotation @Executor");
        }

        String defaultKeyValueLinker = getFieldKeyValueLinker(commandClass.getAnnotation(KeyValueLinker.class), "=");

        String executor = executorAnnotation.value();

        List<String> stringList = new ArrayList<>();
        stringList.add(executor);

        Field[] fields = commandClass.getDeclaredFields();
        if (fields.length == 0) {
            return stringList;
        }
        for (Field field : fields) {
            // todo get field value by getter
            field.setAccessible(true);
            Object value = field.get(command);
            if (value == null) {
                continue;
            }

            NoCommandKey noCommandKeyAnnotation = field.getAnnotation(NoCommandKey.class);

            Class<?> fieldType = field.getType();
            StringBuilder stringBuilder = new StringBuilder();
            if (fieldType == Boolean.class) {
                if ((Boolean) value) {
                    appendCommandKey(stringBuilder, field.getName());
                }
            } else if (fieldType == Integer.class) {
                appendCommandKey(stringBuilder, field.getName());
                stringBuilder = handleKeyAndLinker(field, defaultKeyValueLinker, stringList, stringBuilder);
                stringBuilder.append(value);
            } else if (fieldType == String.class) {
                if (noCommandKeyAnnotation == null) {
                    appendCommandKey(stringBuilder, field.getName());
                    stringBuilder = handleKeyAndLinker(field, defaultKeyValueLinker, stringList, stringBuilder);
                }
                stringBuilder.append(value);
            } else if (fieldType == List.class) {
                String separator = null;
                List list = (List) value;
                if (list.isEmpty()) {
                    continue;
                }
                if (noCommandKeyAnnotation == null) {
                    appendCommandKey(stringBuilder, field.getName());
                    stringBuilder = handleKeyAndLinker(field, defaultKeyValueLinker, stringList, stringBuilder);
                }
                int index = 0;
                for (Object e : list) {
                    if (index > 0) {
                        if (separator == null) {
                            separator = getListValueSeparator(field.getAnnotation(ListValueSeparator.class), File.pathSeparator);
                        }
                        stringBuilder.append(separator);
                    }
                    stringBuilder.append(e.toString());
                    index++;
                }
            }
            stringList.add(stringBuilder.toString());
        }

        return stringList;
    }

    private static StringBuilder handleKeyAndLinker(Field field, String defaultKeyValueLinker, List<String> stringList, StringBuilder stringBuilder) {
        String keyValueLinker = getFieldKeyValueLinker(field.getAnnotation(KeyValueLinker.class), defaultKeyValueLinker);
        if (keyValueLinker.isBlank()) {
            stringList.add(stringBuilder.toString());
            stringBuilder = new StringBuilder();
        } else {
            stringBuilder.append(keyValueLinker);
        }
        return stringBuilder;
    }

    private static String getFieldKeyValueLinker(KeyValueLinker keyValueLinkerAnnotation, String defaultValue) {
        String valueLinker;
        if (keyValueLinkerAnnotation != null) {
            valueLinker = keyValueLinkerAnnotation.value();
        } else {
            valueLinker = defaultValue;
        }
        return valueLinker;
    }

    private static String getListValueSeparator(ListValueSeparator listValueSeparator, String defaultValue) {
        String separator;
        if (listValueSeparator != null) {
            separator = listValueSeparator.value();
        } else {
            separator = defaultValue;
        }
        return separator;
    }

    public static String[] commandToStringArray(Object command) throws IllegalAccessException {
        List<String> stringList = commandToStringList(command);
        return stringList.toArray(new String[stringList.size()]);
    }

    private static void appendCommandKey(StringBuilder stringBuilder, String name) {
        stringBuilder.append("--");
        int length = name.length();
        for (int i = 0; i < length; ) {
            int pieceStart = i;
            int pieceEnd = i;
            char ch = name.charAt(pieceEnd);
            while (ch < 'A' || ch > 'Z') {
                pieceEnd++;
                if (pieceEnd >= length) {
                    stringBuilder.append(name, pieceStart, pieceEnd);
                    return;
                }
                ch = name.charAt(pieceEnd);
            }
            stringBuilder.append(name, pieceStart, pieceEnd);
            stringBuilder.append('-');
            stringBuilder.append(Character.toLowerCase(ch));
            i = pieceEnd + 1;
        }
    }

    private static String toCommandKey(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        appendCommandKey(stringBuilder, name);
        return stringBuilder.toString();
    }

    public static <T> String toString(List<T> list, char separator) {
        if (list == null || list.isEmpty()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (T t : list) {
            if (index > 0) {
                stringBuilder.append(separator);
            }
            stringBuilder.append(t.toString());
            index++;
        }
        return stringBuilder.toString();
    }
}
