package com.koo.member.application.searchhistory;

import com.koo.book.application.SearchTarget;
import com.koo.member.domain.searchhistory.SearchHistory;
import com.koo.member.domain.searchhistory.SearchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SearchHistoryService {
	@Autowired
	private SearchHistoryRepository searchHistoryRepository;

	@Transactional
	public void saveSearched(Long memberId, SearchTarget target, String query) {
		Optional<SearchHistory> searchHistoryOptional = searchHistoryRepository.findByMemberIdAndTargetAndQuery(memberId, target, query);
		if (!searchHistoryOptional.isPresent()) {
			SearchHistory searchHistory = new SearchHistory();
			searchHistory.setMemberId(memberId);
			searchHistory.setTarget(target);
			searchHistory.setQuery(query);

			searchHistoryRepository.save(searchHistory);
		}
	}
}
