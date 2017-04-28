package com.sales.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@SuppressWarnings("serial")
public class NotIdException extends Exception{
	
	public NotIdException(String message) {
        super(message);
    }

}
