package com.koo.member.domain.bookmark;

import com.koo.member.domain.Member;

public interface BookmarkRepository {
	Bookmark save(Bookmark bookmark);
	Bookmark findByMemberIdAndIsbn(Member member, String isbn);

	void deleteByMemberIdAndIsbn(Long memberId, String isbn);
}
