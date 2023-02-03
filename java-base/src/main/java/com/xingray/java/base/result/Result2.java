package com.xingray.java.base.result;

public class Result2<T, T1> {

    private T data;
    private T1 data1;

    private boolean success;
    private String message;
    private int code;
    private Exception exception;

    public static final Result2<Object, Object> OK = new Result2<>(true);
    public static final Result2<Object, Object> FAIL = new Result2<>(false);

    public Result2() {
    }

    public Result2(boolean success) {
        this.success = success;
    }

    public Result2(T data, T1 data1) {
        this.success = true;
        this.data = data;
        this.data1 = data1;
    }

    public Result2(Exception exception) {
        this.success = false;
        this.exception = exception;
        this.message = exception.getMessage();
    }

    public Result2(String message) {
        this.success = false;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T1 getData1() {
        return data1;
    }

    public void setData1(T1 data1) {
        this.data1 = data1;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "Result2{" +
                "data1=" + data +
                ", data2=" + data1 +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", exception=" + exception +
                '}';
    }
}
