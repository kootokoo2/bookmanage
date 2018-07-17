package com.koo.book.application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SearchSort {
	accuracy("정확도순"),
	recency("최신순"),
	sales("판매량순");

	private String description;

	SearchSort(String description) {
		this.description = description;
	}

	public static List<String> getSearchSrots() {
		return Arrays.asList(SearchSort.values()).stream().map(a -> a.name())
			.collect(Collectors.toList());
	}
}
