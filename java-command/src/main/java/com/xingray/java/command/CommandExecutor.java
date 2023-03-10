package com.xingray.java.command;

import java.io.File;

public interface CommandExecutor {
    CommandResult executeSplitCmd(String[] splitCmd, String[] environmentParams, File dir) throws Exception;

    default CommandResult executeSplitCmd(String[] splitCmd, File dir) throws Exception {
        return executeSplitCmd(splitCmd, null, dir);
    }

    default CommandResult executeSplitCmd(String[] splitCmd) throws Exception {
        return executeSplitCmd(splitCmd, null, null);
    }

    default CommandResult execute(String cmd, String[] environmentParams, File dir) throws Exception {
        return executeSplitCmd(CommandUtil.splitCmd(cmd), environmentParams, dir);
    }

    default CommandResult execute(String cmd, File dir) throws Exception {
        return execute(cmd, null, dir);
    }

    default CommandResult execute(String cmd) throws Exception {
        return execute(cmd, null, null);
    }

    default CommandResult executeCommand(Object command, String[] environmentParams, File dir) throws Exception {
        return executeSplitCmd(CommandUtil.commandToStringArray(command), environmentParams, dir);
    }

    default CommandResult executeCommand(Object command, File dir) throws Exception {
        return executeCommand(command, null, dir);
    }

    default CommandResult executeCommand(Object command) throws Exception {
        return executeCommand(command, null, null);
    }
}
