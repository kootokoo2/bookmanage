package com.koo.book.application;

import com.koo.book.domain.BookRepository;
import com.koo.book.domain.BookSearchResult;
import com.koo.member.application.searchhistory.SearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookSearchService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private SearchHistoryService searchHistoryService;

	public BookSearchResult searchBookInfo(SearchAppKey searchAppKey, Long memberId) {
		saveSearchHistory(searchAppKey, memberId);
		return bookRepository.searchBookInfo(searchAppKey);
	}

	private void saveSearchHistory(SearchAppKey searchAppKey, Long memberId) {
		searchHistoryService.saveSearched(memberId, searchAppKey.getTarget(),searchAppKey.getQuery());
	}
}
