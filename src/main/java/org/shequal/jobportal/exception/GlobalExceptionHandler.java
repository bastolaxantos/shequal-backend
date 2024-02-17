package org.shequal.jobportal.exception;

import org.shequal.jobportal.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {JobNotFoundException.class})
    @ResponseBody
    public BaseResponse<String> handleJobNotFoundException(JobNotFoundException ex) {
        return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null);
    }
}
