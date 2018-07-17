package com.koo.book.application;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchAppKey {
	@NotNull
	private String query;
	private SearchSort sort;
	@Max(50)
	private int page = 1;
	@Max(50)
	private int size = 10;
	@NotNull
	private SearchTarget target;
	private String category;
}
