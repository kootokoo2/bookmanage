package com.koo.member.application.searchhistory;

import com.koo.book.application.SearchTarget;
import com.koo.member.application.MemberService;
import com.koo.member.domain.Member;
import com.koo.member.domain.searchhistory.SearchHistory;
import com.koo.member.domain.searchhistory.SearchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SearchHistoryService {
	@Autowired
	private SearchHistoryRepository searchHistoryRepository;

	@Autowired
	private MemberService memberService;

	@Transactional
	public void saveSearched(Long memberId, SearchTarget target, String query) {
		Member member = memberService.getMember(memberId);
		SearchHistory searchHistory = SearchHistory.builder()
			.memberId(member.getId())
			.target(target)
			.query(query)
			.build();

		searchHistoryRepository.save(searchHistory);
	}
}
