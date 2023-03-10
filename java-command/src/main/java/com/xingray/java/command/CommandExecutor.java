package com.xingray.java.command;

import java.io.File;

public interface CommandExecutor {
    int execute(String[] cmd, String[] environmentParams, File dir, ExecuteListener listener);

    default int execute(String[] cmd, File dir, ExecuteListener listener) {
        return execute(cmd, null, dir, listener);
    }

    default int execute(String[] cmd, File dir) {
        return execute(cmd, null, dir, null);
    }

    default int execute(String[] splitCmd, ExecuteListener listener) {
        return execute(splitCmd, null, null, listener);
    }
    default int execute(String[] splitCmd) {
        return execute(splitCmd, null, null, null);
    }

    default int execute(String cmd, String[] environmentParams, File dir, ExecuteListener listener) {
        return execute(CommandUtil.splitCmd(cmd), environmentParams, dir, listener);
    }

    default int execute(String cmd, File dir, ExecuteListener listener) {
        return execute(cmd, null, dir, listener);
    }

    default int execute(String cmd, File dir) {
        return execute(cmd, null, dir, null);
    }

    default int execute(String cmd, ExecuteListener listener){
        return execute(cmd, null, null, listener);
    }

    default int execute(String cmd ){
        return execute(cmd, null, null, null);
    }

    default int execute(Object command, String[] environmentParams, File dir, ExecuteListener listener) throws IllegalAccessException {
        return execute(CommandUtil.commandToStringArray(command), environmentParams, dir, listener);
    }

    default int execute(Object command, File dir, ExecuteListener listener) throws Exception {
        return execute(command, null, dir, listener);
    }

    default int execute(Object command, File dir) throws Exception {
        return execute(command, null, dir, null);
    }

    default int execute(Object command, ExecuteListener listener) throws Exception {
        return execute(command, null, null, listener);
    }

    default int execute(Object command) throws Exception {
        return execute(command, null, null, null);
    }
}
