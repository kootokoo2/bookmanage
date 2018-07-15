package com.koo.member.application.searchhistory;

import com.koo.book.application.SearchTarget;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SearchHistoryVo {
	private Long memberId;
	private SearchTarget target;
	private String query;
}
