package com.koo.web;

import com.koo.book.application.BookSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	private BookSearchService bookSearchService;
	@GetMapping("/hello")
	public String hello() {
		return "main";
	}

	@GetMapping("/test")
	public String test(){
		String test = bookSearchService.test();
		return "test";
	}

}
