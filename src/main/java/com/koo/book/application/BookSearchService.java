package com.koo.book.application;

import com.koo.book.application.exception.DetailSearchFailedException;
import com.koo.book.domain.BookRepository;
import com.koo.book.domain.BookSearchResult;
import com.koo.book.domain.document.Document;
import com.koo.bookmark.application.BookmarkService;
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
	@Autowired
	private BookmarkService bookmarkService;

	public BookSearchResult searchBookInfo(SearchAppKey searchAppKey, Long memberId) {
		saveSearchHistory(searchAppKey, memberId);
		BookSearchResult bookSearchResult = bookRepository.searchBookInfo(searchAppKey);
		List<Document> documents = bookSearchResult.getDocuments();
		initMemberBookmarked(memberId, documents);
		return bookSearchResult;
	}

	private void initMemberBookmarked(Long memberId, List<Document> documents) {
		documents.stream().map(document -> {
			String isbn = document.getIsbn();
			document.setBookMarked(bookmarkService.isExistBookmark(memberId,isbn));
			return this;
		}).collect(Collectors.toList());
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
