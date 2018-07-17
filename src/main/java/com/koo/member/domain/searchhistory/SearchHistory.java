package com.koo.member.domain.searchhistory;

import com.koo.book.application.SearchTarget;
import com.koo.utils.timelistener.CreatedAndModifiedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SearchHistory extends CreatedAndModifiedEntity {
	@Id
	@GeneratedValue
	@Column(name = "searchHistoryId")
	private Long id;

	@Column
	@Enumerated(EnumType.STRING)
	private SearchTarget target;
	@Column
	private String query;

	@Column
	private Long memberId;
}
