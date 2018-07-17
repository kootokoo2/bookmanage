package com.koo.book.application.exception;

public class BookSearchFailedException extends RuntimeException{
	public BookSearchFailedException(String message) {
		super(message);
	}
}
