package com.koo.book.infra;

import com.koo.book.application.SearchSort;
import com.koo.book.application.SearchTarget;
import com.koo.book.domain.category.Category;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchAppKey {
	private String query;
	private SearchSort sort;
	private Integer page;
	private Integer size;
	private SearchTarget target;
	private Integer category;
}
