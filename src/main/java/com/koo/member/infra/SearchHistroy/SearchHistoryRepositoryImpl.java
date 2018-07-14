package com.koo.member.infra.SearchHistroy;

import com.koo.member.domain.searchhistory.SearchHistory;
import com.koo.member.domain.searchhistory.SearchHistoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchHistoryRepositoryImpl extends JpaRepository<SearchHistory, Long>, SearchHistoryRepository {

}
