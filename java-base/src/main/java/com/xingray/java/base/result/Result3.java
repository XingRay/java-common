package com.xingray.java.base.result;

public class Result3<T, T1, T2> {

    private T data;
    private T1 data1;
    private T2 data2;

    private boolean success;
    private String message;
    private int code;
    private Exception exception;

    public static final Result3<Object, Object, Object> OK = new Result3<>(true);
    public static final Result3<Object, Object, Object> FAIL = new Result3<>(false);

    public Result3() {
    }

    public Result3(boolean success) {
        this.success = success;
    }

    public Result3(T data, T1 data1, T2 data2) {
        this.success = true;
        this.data = data;
        this.data1 = data1;
        this.data2 = data2;
    }

    public Result3(Exception exception) {
        this.success = false;
        this.exception = exception;
        this.message = exception.getMessage();
    }

    public Result3(String message) {
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

    public T2 getData2() {
        return data2;
    }

    public void setData2(T2 data2) {
        this.data2 = data2;
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
        return "Result3{" +
                "data1=" + data +
                ", data2=" + data1 +
                ", data3=" + data2 +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", exception=" + exception +
                '}';
    }
}
