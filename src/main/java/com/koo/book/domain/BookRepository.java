package com.koo.book.domain;

import com.koo.book.application.SearchAppKey;

import java.util.Map;

public interface BookRepository {

	Map<String, Object> searchBookInfo(SearchAppKey searchAppKey);

	String test();
}
