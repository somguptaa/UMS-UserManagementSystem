package com.ums.exception;

public class UserIdNotFoundException extends RuntimeException{
	
	public UserIdNotFoundException() {

	}

	public UserIdNotFoundException(String msg){
		super(msg);
		
	}
	
}
