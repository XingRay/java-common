package com.xingray.java.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.function.Consumer;

public class JavaRuntimeCommandExecutor implements CommandExecutor {

    private static final Logger logger = LoggerFactory.getLogger(JavaRuntimeCommandExecutor.class);

    private final Charset charset;

    public JavaRuntimeCommandExecutor(Charset charset) {
        this.charset = charset;
    }

    public JavaRuntimeCommandExecutor() {
        this(StandardCharsets.UTF_8);
    }

    @Override
    public int execute(String[] cmd, String[] environmentParams, File dir, ExecuteListener listener) {
        logger.info("splitCmd:{}\nenvironmentParams:{}\ndir:{}", Arrays.toString(cmd), Arrays.toString(environmentParams), dir);

        try {
            Process process = Runtime.getRuntime().exec(cmd, environmentParams, dir);
            read(process.getInputStream(), charset, new Consumer<String>() {
                @Override
                public void accept(String s) {
                    logger.info(s);
                    if (listener != null) {
                        listener.out(s);
                    }
                }
            });

            read(process.getErrorStream(), charset, new Consumer<String>() {
                @Override
                public void accept(String s) {
                    logger.info(s);
                    if (listener != null) {
                        listener.error(s);
                    }
                }
            });

            process.waitFor();
            int exitValue = process.exitValue();
            logger.info("process.exitValue():{}", exitValue);
            process.destroy();
            if (listener != null) {
                listener.onFinish(exitValue);
            }
            return exitValue;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            if (listener != null) {
                listener.onError(e);
            }
            return -1;
        }
    }

    public void read(InputStream inputStream, Charset charset, Consumer<String> consumer) throws IOException {
        InputStreamReader inInputStreamReader;
        if (charset != null) {
            inInputStreamReader = new InputStreamReader(inputStream, charset);
        } else {
            inInputStreamReader = new InputStreamReader(inputStream);
        }

        BufferedReader inputBufferedReader = new BufferedReader(inInputStreamReader);
        inputBufferedReader.lines().forEach(consumer);
        inInputStreamReader.close();
        inputStream.close();
    }
}
