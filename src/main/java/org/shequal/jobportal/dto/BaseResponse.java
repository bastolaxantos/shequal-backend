package org.shequal.jobportal.dto;

public record BaseResponse<T>(
    int status, String message, T data
) {

}
