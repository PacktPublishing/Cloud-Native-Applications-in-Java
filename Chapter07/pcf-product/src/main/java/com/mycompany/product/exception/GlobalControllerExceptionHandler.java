package com.mycompany.product.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	void handleBadRequests(BadRequestException bre, HttpServletResponse response) throws IOException {
		
		int respCode = (bre.errCode == BadRequestException.ID_NOT_FOUND) ?
						HttpStatus.NOT_FOUND.value() : HttpStatus.BAD_REQUEST.value() ;
						
		response.sendError(respCode, bre.errCode + ":" + bre.getMessage());
	}
}
