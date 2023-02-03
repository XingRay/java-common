package com.xingray.java.base.result;

public class Result<T> {

    private final boolean success;
    private final T data;
    private final int code;
    private final String message;
    private final Exception exception;

    public static final int ERROR_CODE_DEFAULT = -1;
    public static final String MESSAGE_DEFAULT = "unknown error";

    public static final Result<Object> OK = new Result<>(true);
    public static final Result<Object> FAIL = new Result<>(false, null, ERROR_CODE_DEFAULT, MESSAGE_DEFAULT, null);

    public static <V> Result<V> result(boolean success) {
        return success ? success() : failure();
    }

    public static <V> Result<V> success() {
        //noinspection unchecked
        return (Result<V>) OK;
    }

    public static <V> Result<V> success(V v) {
        return new Result<>(true, v, 0, null, null);
    }

    public static <V> Result<V> failure() {
        //noinspection unchecked
        return (Result<V>) FAIL;
    }

    public static <V> Result<V> failure(int code, String message, Exception e) {
        return new Result<>(code, message, e);
    }

    public static <V> Result<V> failure(int code) {
        return failure(code, MESSAGE_DEFAULT, null);
    }

    public static <V> Result<V> failure(String message) {
        return failure(ERROR_CODE_DEFAULT, message, null);
    }

    public static <V> Result<V> failure(int code, String message) {
        return failure(code, message, null);
    }

    public static <V> Result<V> failure(Exception e) {
        return failure(ERROR_CODE_DEFAULT, e.getMessage(), e);
    }

    public static <V> Result<V> failure(Result<?> result) {
        return failure(result.getCode(), result.getMessage(), result.getException());
    }

    public Result() {
        this(true, null, 0, null, null);
    }

    public Result(boolean success) {
        this(success, null, success ? 0 : ERROR_CODE_DEFAULT, null, null);
    }

    public Result(int code, String message, Exception e) {
        this(false, null, code, message, e);
    }

    public Result(boolean success, T data, int code, String message, Exception exception) {
        this.data = data;
        this.success = success;
        this.message = message;
        this.exception = exception;
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Exception getException() {
        return exception;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", data=" + data +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", exception=" + exception +
                '}';
    }
}
