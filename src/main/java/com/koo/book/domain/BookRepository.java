package com.koo.book.domain;

import com.koo.book.infra.SearchAppKey;

public interface BookRepository {
	BookSearchResult searchBookInfo(SearchAppKey searchAppKey);
}
