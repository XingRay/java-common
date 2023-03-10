package com.xingray.java.command;

public class AllRecordExecuteListener implements RecordExecuteListener {


    private final StringBuilder builder;
    private final String separator;

    public AllRecordExecuteListener() {
        this(null);
    }

    public AllRecordExecuteListener(String separator) {
        builder = new StringBuilder();
        this.separator = separator;
    }

    @Override
    public void out(String line) {
        builder.append(line);
        if (separator != null) {
            builder.append(separator);
        }
    }

    @Override
    public void error(String line) {
        builder.append(line);
        if (separator != null) {
            builder.append(separator);
        }
    }

    @Override
    public void onFinish(int exitValue) {

    }

    @Override
    public void onError(Exception e) {

    }

    @Override
    public String getRecord() {
        return builder.toString();
    }
}
