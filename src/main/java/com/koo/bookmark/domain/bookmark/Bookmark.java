package com.koo.bookmark.domain.bookmark;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bookmark {
	@Id
	@GeneratedValue
	@Column(name = "bookmarkId")
	private Long id;

	@Column
	private String isbn;

	@Column
	private Long memberId;

}
