package com.bug;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by amir amirhoshangi@gmail.com
 */

@ControllerAdvice
public class AnotherGeneralExceptionAdviceHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    protected void handleException(Exception e) {
        System.out.println("Whyyyyyyyyyy?");
    }
}
