package com.koo.book.domain.event;

import com.koo.book.application.SearchTarget;
import com.koo.common.event.Event;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookSearchEvent extends Event {
	private String query;
	private SearchTarget target;

	public BookSearchEvent(String query, SearchTarget target) {
		super();
		this.query = query;
		this.target = target;
	}
}
