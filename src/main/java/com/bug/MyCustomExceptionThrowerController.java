package com.bug;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amir amirhoshangi@gmail.com
 */
@RestController
public class MyCustomExceptionThrowerController {

    @RequestMapping(value = "/api/exception-one", method = RequestMethod.GET)
    public String throwExceptionTypeOne() throws ExceptionTypeOne {
        throw new ExceptionTypeOne();
    }

    @RequestMapping(value = "/api/exception-two", method = RequestMethod.GET)
    public String throwExceptionTypeTwo() throws ExceptionTypeTwo {
        throw new ExceptionTypeTwo();
    }
}
