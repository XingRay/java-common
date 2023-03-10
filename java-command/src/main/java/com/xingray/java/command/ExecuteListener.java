package com.xingray.java.command;

public interface ExecuteListener {
    void out(String line);

    void error(String line);

    void onFinish(int exitValue);

    void onError(Exception e);
}
