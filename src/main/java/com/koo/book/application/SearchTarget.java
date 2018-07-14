package com.koo.book.application;

public enum SearchTarget {
	all("전체"),
	title("제목"),
	isbn("ISBN으로 검색"),
	keyword("주제어에서 검색"),
	contents("목차에서 검색"),
	overview("책소개에서 검색"),
	publisher("출판사에서 검색");

	private String description;

	SearchTarget(String description) {
		this.description = description;
	}
}
