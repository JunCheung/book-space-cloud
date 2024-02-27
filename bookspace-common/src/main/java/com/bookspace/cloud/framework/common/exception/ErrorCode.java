package com.bookspace.cloud.framework.common.exception;

import lombok.Data;

@Data
public class ErrorCode {

    /**
     * Error code
     */
    private final Integer code;
    /**
     * error message
     */
    private final String msg;

    public ErrorCode(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }

}
