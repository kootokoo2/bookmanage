package com.koo.book.application;

import com.koo.book.domain.BookRepository;
import com.koo.book.domain.BookSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
public class BookSearchService {
	@Autowired
	private BookRepository bookRepository;

	public BookSearchResult  searchBookInfo(SearchAppKey searchAppKey) {
		return bookRepository.searchBookInfo(searchAppKey);
	}

	public BookSearchResult searchBookInfoWithMap(MultiValueMap<String, String> params) {
		return bookRepository.searchBookInfo(params);
	}
}
