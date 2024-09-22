package com.souvik.SpringHibernateCrudSwagger.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExeptionAdvice {
	
	@ExceptionHandler(value = BuisnessExeption.class)
	public ResponseEntity<?> handleBuisnessExeption(BuisnessExeption ex){
		return new ResponseEntity<BuisnessExeption>(ex,HttpStatus.BAD_REQUEST);
		
	}
}
