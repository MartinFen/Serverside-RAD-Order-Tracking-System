package com.sales.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@SuppressWarnings("serial")
public class NotCIdException extends Exception{
	
	public NotCIdException(String message) {
        super(message);
    }

}
