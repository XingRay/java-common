package com.xingray.java.installer.test;

import com.xingray.java.command.CommandExecutor;
import com.xingray.java.command.JavaRuntimeCommandExecutor;
import com.xingray.java.installer.JDepsCommand;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.Charset;

public class CommandTest {

    @Test
    public void jdepsCommandTest() throws Exception {
        JDepsCommand jDepsCommand = new JDepsCommand();
        jDepsCommand.setRecursive(true);
        jDepsCommand.setTarget(new File("src\\test\\resources\\generator-test01-1.0.0.jar").getAbsolutePath());

        CommandExecutor executor = new JavaRuntimeCommandExecutor(Charset.forName("GBK"));

        int result = executor.execute(jDepsCommand);
        System.out.println(result);
        assert result == 0;
    }
}
