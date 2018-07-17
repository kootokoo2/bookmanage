package com.koo.book.application;

import com.koo.book.domain.category.Category;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchAppKeyDto {
	@NotNull
	private String query;
	private SearchSort sort;
	@Max(50)
	private Integer page;
	@Max(50)
	private Integer size;
	@NotNull
	private SearchTarget target;
	private Category category;
}
