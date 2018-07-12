package com.koo.book.application;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class SearchAppKey {
	@NotNull
	private String query;
	private SearchSort sort;
	private int page;
	private int size;
	private SearchType target;
	private int category;

}
