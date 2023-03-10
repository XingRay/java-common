package com.xingray.java.command.test;

import com.xingray.java.command.CommandExecutor;
import com.xingray.java.command.CommandResult;
import com.xingray.java.command.JavaRuntimeCommandExecutor;
import com.xingray.java.util.SystemUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

class JavaRuntimeCommandExecutorTest {

    private CommandExecutor executor;

    @BeforeEach
    public void beforeEach() {
        executor = new JavaRuntimeCommandExecutor(StandardCharsets.UTF_8, System.out::println);
    }

    @Test
    void executeSplitCmd() throws Exception {
        CommandResult result = executor.execute("java -version");
        int exitValue = result.getExitValue();
        System.out.println(exitValue);
        assert exitValue == 0;
    }

    @Test
    public void testDir() throws Exception {
        String cmd = SystemUtil.isRunOnWindows() ? "mvn.cmd -version" : "mvn -version";
        CommandResult result = executor.execute(cmd);
        int exitValue = result.getExitValue();
        System.out.println(exitValue);
        assert exitValue == 0;
    }
}