package com.response;

import java.io.Serializable;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2018-04-16
 * Copyright  "Commercegate LTD"
 */
public class FailResponse implements IResponse, Serializable {

    private String message;

    private Integer code;

    public FailResponse(Integer errorCode, String errorText) {
        this.message = errorText;
        this.code = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }
}
