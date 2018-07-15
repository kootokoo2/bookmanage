package com.koo.member.application.exception;

public class AlreadySavedIsbn extends RuntimeException{
	public AlreadySavedIsbn(String message) {
		super(message);
	}
}
