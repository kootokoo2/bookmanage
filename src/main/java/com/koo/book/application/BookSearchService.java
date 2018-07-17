package com.koo.book.application;

import com.koo.book.application.exception.BookSearchFailedException;
import com.koo.book.domain.BookRepository;
import com.koo.book.domain.BookSearchResult;
import com.koo.book.domain.document.Document;
import com.koo.book.infra.SearchAppKey;
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
		try{
			saveSearchHistory(searchAppKey, memberId);
			BookSearchResult bookSearchResult = bookRepository.searchBookInfo(searchAppKey);
			return bookSearchResult;
		} catch (Exception e) {
			throw new BookSearchFailedException("상세 정보를 조회 할 수 없습니다. searchKey : " + searchAppKey.toString());
		}

	}

	public Document detailSearch(SearchAppKey searchAppKey) {
		try{
			BookSearchResult bookSearchResult = bookRepository.searchBookInfo(searchAppKey);
			return bookSearchResult.getDocuments().get(0);
		} catch (Exception e) {
			throw new BookSearchFailedException("상세 정보를 조회 할 수 없습니다. searchKey : " + searchAppKey.toString());
		}

	}

	private void saveSearchHistory(SearchAppKey searchAppKey, Long memberId) {
		searchHistoryService.saveSearched(memberId, searchAppKey.getTarget(), searchAppKey.getQuery());
	}


}
