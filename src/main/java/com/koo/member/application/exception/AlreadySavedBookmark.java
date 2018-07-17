package com.koo.member.application.exception;

public class AlreadySavedBookmark extends RuntimeException{
	public AlreadySavedBookmark(String message) {
		super(message);
	}
}
