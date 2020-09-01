package com.app.controller;

import com.app.exceptions.FileStorageException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(FileStorageException.class)
    public ModelAndView handleException(FileStorageException exception,
                                        RedirectAttributes redirectAttributes){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message",exception.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
