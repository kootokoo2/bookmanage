package com.koo.web;

import com.koo.book.application.BookSearchService;
import com.koo.book.application.SearchAppKey;
import com.koo.book.domain.BookSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	private BookSearchService bookSearchService;

	@GetMapping("/hello")
	public String hello() {
		return "main";
	}

	@PostMapping("/search")
	public String search(@RequestBody SearchAppKey searchAppKey) {
		BookSearchResult bookSearchResult = bookSearchService.searchBookInfo(searchAppKey, searchAppKey.getMemberId());
		return bookSearchResult.toString();
	}

}
