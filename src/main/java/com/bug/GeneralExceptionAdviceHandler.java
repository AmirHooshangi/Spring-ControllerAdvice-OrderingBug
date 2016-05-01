package com.bug;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by amir amirhoshangi@gmail.com
 */

@ControllerAdvice
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class GeneralExceptionAdviceHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    protected void handleRuntTimeException(RuntimeException e) {
        System.out.println("Why?");
    }

 /*   @ExceptionHandler({Exception.class})
    protected void handleException(Exception e) {
        System.out.println("Whyyyyyyyyyy?");
    }*/
}
