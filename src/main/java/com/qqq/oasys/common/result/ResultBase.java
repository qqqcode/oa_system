package com.qqq.oasys.common.result;

import com.qqq.oasys.common.code.StatusCode;

import java.io.Serializable;

public class ResultBase implements Serializable {

    private Boolean success = true;

    private StatusCode statusCode;

    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
