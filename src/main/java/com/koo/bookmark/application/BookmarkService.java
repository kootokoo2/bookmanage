package com.koo.bookmark.application;

import com.koo.bookmark.domain.bookmark.Bookmark;
import com.koo.bookmark.domain.bookmark.BookmarkRepository;
import com.koo.member.application.MemberService;
import com.koo.member.application.exception.AlreadySavedBookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class BookmarkService {
	@Autowired
	private BookmarkRepository bookmarkRepository;

	@Autowired
	private MemberService memberService;

	public boolean isBookmarked(Long memberId, String isbn) {
		Optional<Bookmark> byMemberIdAndIsbn = bookmarkRepository.findByMemberIdAndIsbn(memberId, isbn);
		return byMemberIdAndIsbn.isPresent();
	}

	@Transactional
	public void save(BookmarkVo bookmarkVo) {
		Long memberId = bookmarkVo.getMemberId();
		String isbn = bookmarkVo.getIsbn();

		if (isBookmarked(memberId,isbn)) {
			throw new AlreadySavedBookmark("이미 저장된 Bookmark 입니다. isbn : " + isbn);
		} else {
			Bookmark bookmark = new Bookmark();
			bookmark.setMemberId(memberId);
			bookmark.setIsbn(isbn);
			bookmarkRepository.save(bookmark);
		}
	}

	@Transactional
	public void delete(BookmarkVo bookmarkVo) {
		bookmarkRepository.deleteByMemberIdAndIsbn(bookmarkVo.getMemberId(), bookmarkVo.getIsbn());
	}

}
