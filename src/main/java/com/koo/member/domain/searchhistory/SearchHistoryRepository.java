package com.koo.member.domain.searchhistory;

import com.koo.book.application.SearchTarget;

import java.util.Optional;

public interface SearchHistoryRepository {
	SearchHistory save(SearchHistory searchHistory);

	Optional<SearchHistory> findByMemberIdAndTargetAndQuery(Long memberId, SearchTarget target, String query);
}
