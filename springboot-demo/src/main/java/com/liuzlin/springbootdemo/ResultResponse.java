package com.liuzlin.springbootdemo;

import java.io.Serializable;

public class ResultResponse<T> implements Serializable {

    private String code;

    private String message;

    private T date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public static ResultResponse success(Object date) {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setCode("0000");
        resultResponse.setDate(date);
        return resultResponse;
    }
}
