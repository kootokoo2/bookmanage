package com.koo.book.application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	public static List<String> getSearchTargets() {
		return Arrays.asList(SearchTarget.values()).stream().map(a -> a.name())
			.collect(Collectors.toList());
	}

}
