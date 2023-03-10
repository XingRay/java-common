package com.xingray.java.command;

public abstract class SimpleExecuteListener implements ExecuteListener{

    public abstract void out(String line);

    @Override
    public void error(String line) {

    }

    @Override
    public void onFinish(int exitValue) {

    }

    @Override
    public void onError(Exception e) {

    }
}
