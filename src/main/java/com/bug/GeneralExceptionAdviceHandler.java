package com.bug;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by amir amirhoshangi@gmail.com
 */

@ControllerAdvice
public class GeneralExceptionAdviceHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    protected void handleAuditLogException(Exception e) {
        System.out.println("Why?");
    }
}
