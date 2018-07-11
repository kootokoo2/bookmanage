package com.koo.member.application.exception;

public class ExistUserException extends RuntimeException{
	public ExistUserException(String message) {
		super(message);
	}
}
