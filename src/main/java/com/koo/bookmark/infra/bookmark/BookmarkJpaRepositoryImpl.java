package com.koo.bookmark.infra.bookmark;

import com.koo.bookmark.domain.bookmark.Bookmark;
import com.koo.bookmark.domain.bookmark.BookmarkRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkJpaRepositoryImpl extends JpaRepository<Bookmark, Long>, BookmarkRepository {
	void deleteByMemberIdAndIsbn(long memberId, String isbn);
}
