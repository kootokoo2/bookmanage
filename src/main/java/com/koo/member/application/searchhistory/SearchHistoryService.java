package com.koo.member.application.searchhistory;

import com.koo.book.application.SearchTarget;
import com.koo.member.domain.searchhistory.SearchHistory;
import com.koo.member.domain.searchhistory.SearchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SearchHistoryService {
	@Autowired
	private SearchHistoryRepository searchHistoryRepository;

	@Transactional
	public void saveSearched(SearchHistoryVo searchHistoryVo) {
		saveSearched(123L, searchHistoryVo.getTarget(), searchHistoryVo.getQuery());
	}

	@Transactional
	public void saveSearched(Long memberId, SearchTarget target, String query) {
		SearchHistory searchHistory = SearchHistory.builder()
			.memberId(memberId)
			.target(target)
			.query(query)
			.build();

		searchHistoryRepository.save(searchHistory);
	}
}
