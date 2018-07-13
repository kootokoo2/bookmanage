package com.koo.book.application;

import com.koo.book.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BookSearchService {
	@Autowired
	private BookRepository bookRepository;

	public Map<String,Object> searchBookInfo(SearchAppKey searchAppKey){
		Map<String,Object> searched = bookRepository.searchBookInfo(searchAppKey);
		return searched;
	}
	public String test(){
		return bookRepository.test();
	}
}
