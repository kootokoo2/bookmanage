package com.koo.book.domain;

import com.koo.book.application.SearchAppKey;
import org.springframework.util.MultiValueMap;

public interface BookRepository {

	BookSearchResult searchBookInfo(SearchAppKey searchAppKey);
	BookSearchResult searchBookInfo(MultiValueMap<String,String> params);
}
