package com.bookspace.cloud.framework.common.exception.enums;


import com.bookspace.cloud.framework.common.exception.ErrorCode;

/**
 * Global Error Code Enum
 */
public interface GlobalErrorCodeConstants {

    ErrorCode SUCCESS = new ErrorCode(0, "success");

    ErrorCode BAD_REQUEST = new ErrorCode(400, "bad request");
    ErrorCode UNAUTHORIZED = new ErrorCode(401, "unauthorized");
    ErrorCode FORBIDDEN = new ErrorCode(403, "forbidden");
    ErrorCode NOT_FOUND = new ErrorCode(404, "not found");


    ErrorCode INTERNAL_SERVER_ERROR = new ErrorCode(500, "internal server error");

}
