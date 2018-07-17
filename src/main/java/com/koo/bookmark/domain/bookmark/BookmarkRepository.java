package com.koo.bookmark.domain.bookmark;

import java.util.Optional;

public interface BookmarkRepository {
	Bookmark save(Bookmark bookmark);

	Optional<Bookmark> findByMemberIdAndIsbn(Long memberId, String isbn);

	void deleteByMemberIdAndIsbn(Long memberId, String isbn);

}
