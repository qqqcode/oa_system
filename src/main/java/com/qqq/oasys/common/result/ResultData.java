package com.qqq.oasys.common.result;

public class ResultData<T> extends ResultBase {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
