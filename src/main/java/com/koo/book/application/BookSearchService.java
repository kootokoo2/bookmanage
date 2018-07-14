package com.koo.book.application;

import com.koo.book.domain.BookRepository;
import com.koo.book.domain.BookSearchResult;
import com.koo.book.domain.event.BookSearchEvent;
import com.koo.common.event.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookSearchService {
	@Autowired
	private BookRepository bookRepository;

	public BookSearchResult searchBookInfo(SearchAppKey searchAppKey) {
		//todo search event 등록
//		Events.handle((OrderCanceledEvent evt) -> refundService.refund(evt.getOrderNumber()));
		Events.handle((BookSearchEvent event) ->  new BookSearchEvent(searchAppKey.getQuery(), searchAppKey.getTarget()));
		return bookRepository.searchBookInfo(searchAppKey);
	}

}
