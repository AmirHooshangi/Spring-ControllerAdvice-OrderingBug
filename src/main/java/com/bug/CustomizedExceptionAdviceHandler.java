package com.bug;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by amir amirhoshangi@gmail.com
 */
@ControllerAdvice
public class CustomizedExceptionAdviceHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ExceptionTypeOne.class})
    protected void handleExceptionTypeOne(ExceptionTypeOne e) {
        System.out.println("ExceptionTypeOne");
    }

    @ExceptionHandler({ExceptionTypeTwo.class})
    protected void handleExceptionTypeTwo(ExceptionTypeTwo e) {
        System.out.println("ExceptionTypeTwo");
    }
}
