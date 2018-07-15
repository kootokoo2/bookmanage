package com.koo.book.application;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchAppKey {
	private String query;
	private SearchSort sort;
	private Integer page;
	private Integer size;
	private SearchTarget target;
	private String category;
}
