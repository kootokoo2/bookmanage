package com.koo.member.domain;

import com.koo.bookmark.domain.bookmark.Bookmark;
import com.koo.member.domain.searchhistory.SearchHistory;
import com.koo.utils.timelistener.CreatedAndModifiedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Member extends CreatedAndModifiedEntity {
	@Id
	@GeneratedValue
	@Column(name = "memberId")
	private Long id;

	@Column
	private String userId;
	@Column
	private String password;

	public boolean match(String password) {
		return this.password.equals(password);
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "memberId")
	private List<Bookmark> bookmarkList;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "memberId")
	private List<SearchHistory> searchHistoryList;

	public String makeEncryptionPassword(PasswordEncoder passwordEncoder, String origin) {
		return passwordEncoder.encode(origin);
	}

}
