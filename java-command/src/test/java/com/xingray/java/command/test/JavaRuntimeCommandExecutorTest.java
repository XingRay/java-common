package com.xingray.java.command.test;

import com.xingray.java.command.CommandExecutor;
import com.xingray.java.command.JavaRuntimeCommandExecutor;
import com.xingray.java.command.SimpleExecuteListener;
import com.xingray.java.util.SystemUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

class JavaRuntimeCommandExecutorTest {

    private CommandExecutor executor;

    @BeforeEach
    public void beforeEach() {
        executor = new JavaRuntimeCommandExecutor();
    }

    @Test
    void executeSplitCmd() {
        // 注意 java --version 会走out， java -version 会走err，因为本来java查询版本应该使用--version 而不是-version，而且输出会有细微的区别

        // out:openjdk 19 2022-09-20
        int exitValue1 = executor.execute("java --version", new SimpleExecuteListener() {
            @Override
            public void out(String line) {
                System.out.println("out:" + line);
            }
        });
        assert exitValue1 == 0;

        // error:openjdk version "19" 2022-09-20
        int exitValue2 = executor.execute("java -version", new SimpleExecuteListener() {
            @Override
            public void error(String line) {
                System.out.println("error:" + line);
            }
        });
        assert exitValue2 == 0;
    }

    @Test
    public void testDir() throws Exception {
        String cmd = SystemUtil.isRunOnWindows() ? "mvn.cmd -version" : "mvn -version";
        int exitValue = executor.execute(cmd);
        System.out.println(exitValue);
        assert exitValue == 0;
    }

    @Test
    public void makeAndRunTest() {
        CommandExecutor executor = new JavaRuntimeCommandExecutor();
        String artifactId = "generator-test01";
        String version = "1.0.0";

        try {
            String cmd = SystemUtil.isRunOnWindows() ? "mvn.cmd clean package" : "mvn clean package";
            File projectRootFile = new File("src\\test\\resources\\generator-test01");
            int result = executor.execute(cmd, projectRootFile);
            assert result == 0;

            cmd = "java -jar " + artifactId + "-" + version + ".jar";
            result = executor.execute(cmd, new File(projectRootFile, "target"));
            assert result == 0;

            cmd = SystemUtil.isRunOnWindows() ? "mvn.cmd clean" : "mvn clean";
            result = executor.execute(cmd, projectRootFile);
            assert result == 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test02() {
        File file = new File("src\\test\\resources\\generator-test01");
        System.out.println(file.getAbsolutePath());
    }

}