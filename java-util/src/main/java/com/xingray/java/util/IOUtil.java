package com.xingray.java.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOUtil {
    public static String inputStreamToString(InputStream inputStream, String charset) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString(charset);
    }

    public static String inputStreamToString(InputStream inputStream) throws IOException {
        return inputStreamToString(inputStream, "UTF-8");
    }
}
