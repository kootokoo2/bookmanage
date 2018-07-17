package com.koo.member.domain.bookmark;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
