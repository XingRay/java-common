package com.xingray.java.command;

public class LastRecordExecuteListener implements RecordExecuteListener {

    private String lastLine;

    @Override
    public void out(String line) {
        lastLine = line;
    }

    @Override
    public void error(String line) {
        lastLine = line;
    }

    @Override
    public void onFinish(int exitValue) {

    }

    @Override
    public void onError(Exception e) {

    }

    @Override
    public String getRecord() {
        return lastLine;
    }
}
