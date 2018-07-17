package com.koo.bookmark.application;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookmarkVo {
	private Long memberId;
	private String isbn;
}
