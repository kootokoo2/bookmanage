package com.koo.member.application.bookmark;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookmarkVo {
	private Long memberId;
	private String title;
	private String isbn;
}
