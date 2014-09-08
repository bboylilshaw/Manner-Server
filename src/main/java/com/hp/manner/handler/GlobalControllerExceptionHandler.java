package com.hp.manner.handler;

import com.hp.manner.exception.AppException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    private static final String ERROR_PAGE = "error.html";

    @ExceptionHandler(AppException.class)
    public ModelAndView handleCustomException(HttpServletRequest req, AppException ae) {
        ModelAndView modelAndView = new ModelAndView(ERROR_PAGE);
        modelAndView.addObject("message", ae.getMessage());
        modelAndView.addObject("exception", ae);
        modelAndView.addObject("url", req.getRequestURL());
        return modelAndView;

    }

//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleAllException(HttpServletRequest req,Exception e) {
//        ModelAndView modelAndView = new ModelAndView(ERROR_PAGE);
//        modelAndView.addObject("errMsg", e.getMessage());
//        modelAndView.addObject("exception", e);
//        modelAndView.addObject("url", req.getRequestURL());
//        return modelAndView;
//    }
}
