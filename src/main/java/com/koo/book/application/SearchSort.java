package com.koo.book.application;

public enum SearchSort {
	accuracy("정확도순"),
	recency("최신순"),
	sales("판매량순");

	private String description;

	SearchSort(String description) {
		this.description = description;
	}
}
