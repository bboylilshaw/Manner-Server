package com.hp.manner.controller;

import com.hp.manner.exception.AppException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionController {

    public static final String ERROR_PAGE = "error";

    @ExceptionHandler(AppException.class)
    public ModelAndView handleCustomException(AppException ae) {
        ModelAndView modelAndView = new ModelAndView(ERROR_PAGE);
        modelAndView.addObject("errCode", ae.getErrCode());
        modelAndView.addObject("errMsg", ae.getErrMsg());
        return modelAndView;

    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(HttpServletRequest req,Exception e) {
        ModelAndView modelAndView = new ModelAndView(ERROR_PAGE);
        modelAndView.addObject("errMsg", e.getMessage());
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", req.getRequestURL());
        return modelAndView;
    }
}
