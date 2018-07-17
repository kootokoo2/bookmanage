package com.koo.book.application;

import com.koo.book.application.exception.DetailSearchFailedException;
import com.koo.book.domain.BookRepository;
import com.koo.book.domain.BookSearchResult;
import com.koo.book.domain.document.Document;
import com.koo.member.application.searchhistory.SearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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


	public Document detailSearch(SearchAppKey searchAppKey) {
		try{
			BookSearchResult bookSearchResult = bookRepository.searchBookInfo(searchAppKey);
			return bookSearchResult.getDocuments().get(0);
		} catch (Exception e) {
			throw new DetailSearchFailedException("상세 정보를 조회 할 수 없습니다");
		}

	}

	private void saveSearchHistory(SearchAppKey searchAppKey, Long memberId) {
		searchHistoryService.saveSearched(memberId, searchAppKey.getTarget(), searchAppKey.getQuery());
	}

	public List<String> getSearchTargetList() {
		return Arrays.asList(SearchTarget.values()).stream().map(a -> a.name())
			.collect(Collectors.toList());
	}
}
