package com.xingray.java.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaRuntimeCommandExecutor implements CommandExecutor {

    private Charset charset;
    private Consumer<String> consumer;


    public JavaRuntimeCommandExecutor() {
        this(null, null);
    }

    public JavaRuntimeCommandExecutor(Charset charset, Consumer<String> consumer) {
        this.charset = charset;
        this.consumer = consumer;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public void setConsumer(Consumer<String> consumer) {
        this.consumer = consumer;
    }

    @Override
    public CommandResult executeSplitCmd(String[] splitCmd, String[] environmentParams, File dir) throws Exception {

        BufferedReader inputBufferedReader = null;
        BufferedReader errorBufferedReader = null;
        try {
            System.out.println("splitCmd:" + Arrays.toString(splitCmd) + "\n"
                    + "environmentParams:" + Arrays.toString(environmentParams) + "\n"
                    + "dir:" + dir);

            Process process = Runtime.getRuntime().exec(splitCmd, environmentParams, dir);
            InputStreamReader inInputStreamReader;
            if (charset != null) {
                inInputStreamReader = new InputStreamReader(process.getInputStream(), charset);
            } else {
                inInputStreamReader = new InputStreamReader(process.getInputStream());
            }

            inputBufferedReader = new BufferedReader(inInputStreamReader);
            Stream<String> inputStream = inputBufferedReader.lines();
            if (consumer != null) {
                inputStream = inputStream.peek(consumer);
            }
            List<String> resultStringList = inputStream.collect(Collectors.toList());

            InputStreamReader errorInputStreamReader;
            if (charset != null) {
                errorInputStreamReader = new InputStreamReader(process.getErrorStream(), charset);
            } else {
                errorInputStreamReader = new InputStreamReader(process.getErrorStream());
            }
            errorBufferedReader = new BufferedReader(errorInputStreamReader);
            Stream<String> errorStream = errorBufferedReader.lines();
            if (consumer != null) {
                errorStream = errorStream.peek(consumer);
            }
            List<String> errorStringList = errorStream.collect(Collectors.toList());

            process.waitFor();
            int exitValue = process.exitValue();
            process.destroy();

            return new CommandResult(exitValue, resultStringList, errorStringList);
        } finally {
            if (inputBufferedReader != null) {
                inputBufferedReader.close();
            }
            if (errorBufferedReader != null) {
                errorBufferedReader.close();
            }
        }
    }
}
