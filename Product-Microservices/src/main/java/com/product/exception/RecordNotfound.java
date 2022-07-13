package com.product.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)


public class RecordNotfound extends Exception {

	private static final long serialVersionUID = 1L;
	private String msg;
	public RecordNotfound(String msg) {
		super();
		this.msg = msg;
	}
	
}
