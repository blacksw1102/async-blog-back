package com.blacksw.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blacksw.service.CommonResponse;

@RestControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(EmailLoginFailedException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected CommonResponse emailLoginFailedException(HttpServletRequest request, EmailLoginFailedException e) {
		return null;
	}
	
}
