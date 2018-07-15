package com.koo.member.domain;

import com.koo.member.domain.bookmark.Bookmark;
import com.koo.member.domain.searchhistory.SearchHistory;
import com.koo.utils.timelistener.CreatedAndModifiedEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
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

	private String getPassword() {
		return password;
	}

	public boolean match(String password) {
		return this.password.equals(password);
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "memberId")
	private List<Bookmark> bookmarkList;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "searchHistoryId")
	private List<SearchHistory> searchHistoryList;

	public String makeEncryptionPassword(PasswordEncoder passwordEncoder, String origin) {
		return passwordEncoder.encode(origin);
	}

	public boolean hasBookmakrAlready(String isbn) {
		List<String> isbnList = this.bookmarkList.stream().map(bookmark -> bookmark.getIsbn()).collect(Collectors.toList());
		return isbnList.contains(isbn);
	}

}
