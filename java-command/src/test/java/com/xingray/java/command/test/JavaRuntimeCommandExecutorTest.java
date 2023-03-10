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
    void executeSplitCmd() throws Exception {
        int exitValue = executor.execute("java -version", new SimpleExecuteListener() {
            @Override
            public void out(String line) {
                System.out.println(line);
            }
        });
        assert exitValue == 0;
    }

    @Test
    public void testDir() throws Exception {
        String cmd = SystemUtil.isRunOnWindows() ? "mvn.cmd -version" : "mvn -version";
        int exitValue = executor.execute(cmd, new SimpleExecuteListener() {
            @Override
            public void out(String line) {
                System.out.println(line);
            }
        });
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
            File projectRootFile = new File("D:\\code\\workspace\\java\\generator-test01");
            int result01 = executor.execute(cmd, projectRootFile, new SimpleExecuteListener() {
                @Override
                public void out(String line) {
                    System.out.println(line);
                }
            });
            System.out.println(result01);
            assert result01 == 0;


            cmd = "java -jar " + artifactId + "-" + version + ".jar";
            int result02 = executor.execute(cmd, new File(projectRootFile, "target"), new SimpleExecuteListener() {
                @Override
                public void out(String line) {
                    assert line.equals("hello world");
                }
            });
            System.out.println(result02);
            assert result02 == 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}