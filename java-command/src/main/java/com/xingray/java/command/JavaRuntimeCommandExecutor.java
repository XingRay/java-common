package com.xingray.java.command;

import com.xingray.java.util.StringUtil;
import com.xingray.java.util.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class JavaRuntimeCommandExecutor implements CommandExecutor {

    private static final Logger logger = LoggerFactory.getLogger(JavaRuntimeCommandExecutor.class);

    private final Charset charset;

    private Executor outReadExecutor;

    private Executor errorReadExecutor;

    private Map<String, String> env;

    public JavaRuntimeCommandExecutor(Charset charset) {
        if (charset == null) {
            throw new IllegalArgumentException("charset can not be null !");
        }
        this.charset = charset;
    }

    public JavaRuntimeCommandExecutor() {
        this(StandardCharsets.UTF_8);
    }

    public void setOutReadExecutor(Executor executor) {
        this.outReadExecutor = executor;
    }

    public void setErrorReadExecutor(Executor executor) {
        this.errorReadExecutor = executor;
    }

    public void putEnv(String key, String value) {
        if (env == null) {
            env = new HashMap<>();
        }
        env.put(key, value);
    }

    public void setReadExecutor(Executor executor) {
        setOutReadExecutor(executor);
        setErrorReadExecutor(executor);
    }


    @Override
    public int execute(String[] cmd, String[] environmentParams, File dir, ExecuteListener listener) {
        logger.info("cmd:{}\nenvironmentParams:{}\ndir:{}", Arrays.toString(cmd), Arrays.toString(environmentParams), dir);

        cmd[0] = replaceCmdExecutor(cmd[0]);

        try {
            Process process = Runtime.getRuntime().exec(cmd, environmentParams, dir);

//            ProcessBuilder processBuilder = new ProcessBuilder(cmd)
//                    .directory(dir);
//
//            Map<String, String> systemEnv = processBuilder.environment();
//            env.forEach(new BiConsumer<String, String>() {
//                @Override
//                public void accept(String key, String value) {
//                    systemEnv.put(key, value);
//                }
//            });
//            process = processBuilder.start();

            Runnable readOutTask = new Runnable() {
                @Override
                public void run() {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), charset))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            logger.info(line);
                            if (listener != null) {
                                listener.out(line);
                            }
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        logger.error(ex.getMessage());
                        if (listener != null) {
                            listener.error(ex.getMessage());
                        }
                    }
                }
            };
            if (this.outReadExecutor == null) {
                new Thread(readOutTask).start();
            } else {
                outReadExecutor.execute(readOutTask);
            }

            Runnable readErrorTask = new Runnable() {
                @Override
                public void run() {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream(), charset))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            logger.info(line);
                            if (listener != null) {
                                listener.error(line);
                            }
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        logger.error(ex.getMessage());
                        if (listener != null) {
                            listener.error(ex.getMessage());
                        }
                    }
                }
            };

            if (errorReadExecutor == null) {
                new Thread(readErrorTask).start();
            } else {
                errorReadExecutor.execute(readErrorTask);
            }

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

    private String replaceCmdExecutor(String cmdExecutor) {
        File executorFile = new File(cmdExecutor);
        if (executorFile.exists()) {
            return cmdExecutor;
        }

        File executionFile = findExecutionFile(cmdExecutor);
        if (executionFile != null) {
            String executionFileAbsolutePath = executionFile.getAbsolutePath();
            logger.info("replace cmd[0] from {} to {}", cmdExecutor, executionFileAbsolutePath);
            return executionFileAbsolutePath;
        }

        return cmdExecutor;
    }

    private File findExecutionFile(String cmdExecutor) {
        if (SystemUtil.isRunOnWindows()) {
            return findExecutionFileOnWindows(cmdExecutor);
        }
        // TODO: 2023/3/11 for linux mac
        return null;
    }

    private File findExecutionFileOnWindows(String cmdExecution) {
        Map<String, String> env = System.getenv();
        if (env == null || env.isEmpty()) {
            return null;
        }

        String pathKey = null;
        for (String key : env.keySet()) {
            if (key.equalsIgnoreCase("path")) {
                pathKey = key;
            }
        }
        if (pathKey == null) {
            return null;
        }
        String path = env.get(pathKey);
        if (StringUtil.isEmpty(path)) {
            logger.info("path is empty, env:{}", env);
            return null;
        }
        String[] locations = path.split(";");

        int index = cmdExecution.lastIndexOf(".");
        if (index >= 0) {
            String cmdSuffix = cmdExecution.substring(index);
            System.out.println(cmdSuffix);
            for (String location : locations) {
                File file = new File(location, cmdExecution);
                if (file.exists()) {
                    return file;
                }
            }
        } else {
            String[] suffixes = new String[]{".exe", ".cmd", ".bat", ".com", ""};
            for (String location : locations) {
                for (String suffix : suffixes) {
                    File file = new File(location, cmdExecution + suffix);
                    if (file.exists()) {
                        return file;
                    }
                }
            }
        }
        return null;
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
