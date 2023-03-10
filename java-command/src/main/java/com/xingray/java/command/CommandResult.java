package com.xingray.java.command;

import java.util.List;

public class CommandResult {
    private int exitValue;

    private List<String> resultStringList;
    private String resultString;

    private List<String> errorStringList;
    private String errorString;

    public CommandResult(int exitValue, List<String> resultStringList, List<String> errorStringList) {
        this.exitValue = exitValue;
        this.resultStringList = resultStringList;
        this.errorStringList = errorStringList;
    }

    public int getExitValue() {
        return exitValue;
    }

    public List<String> getResultStringList() {
        return resultStringList;
    }

    public List<String> getErrorStringList() {
        return errorStringList;
    }

    @Override
    public String toString() {
        return "CommandResult{" +
                "exitValue=" + exitValue +
                ", resultStringList=" + resultStringList +
                ", errorStringList=" + errorStringList +
                '}';
    }

    public String getResult() {
        if (resultString != null) {
            return resultString;
        }
        if (resultStringList == null) {
            return null;
        }
        resultString = CommandUtil.toString(resultStringList, '\n');
        return resultString;
    }

    public String getError() {
        if (errorString != null) {
            return errorString;
        }
        if (errorStringList == null) {
            return null;
        }
        errorString = CommandUtil.toString(errorStringList, '\n');
        return errorString;
    }
}
