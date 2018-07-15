package com.koo.member.application.bookmark;

import com.koo.member.application.MemberService;
import com.koo.member.application.exception.AlreadySavedIsbn;
import com.koo.member.domain.Member;
import com.koo.member.domain.bookmark.Bookmark;
import com.koo.member.domain.bookmark.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BookmarkService {
	@Autowired
	private BookmarkRepository bookmarkRepository;

	@Autowired
	private MemberService memberService;

	@Transactional
	public void save(BookmarkVo bookmarkVo) {
		Member member = memberService.getMember(bookmarkVo.getMemberId());
		String isbn = bookmarkVo.getIsbn();

		if(member.hasBookmakrAlready(isbn)) {
			throw new AlreadySavedIsbn("이미 저장된 ISBN 입니다. isbn : " + isbn);
		} else {
			Bookmark bookmark = makeBookmark(bookmarkVo, member.getId());
			member.getBookmarkList().add(bookmark);
			bookmarkRepository.save(bookmark);
		}
	}

	@Transactional
	public void delete(BookmarkVo bookmarkVo) {
		bookmarkRepository.deleteByMemberIdAndIsbn(bookmarkVo.getMemberId(), bookmarkVo.getIsbn());
	}

	private Bookmark makeBookmark(BookmarkVo bookmarkVo, Long memberId) {
		return Bookmark.builder()
				.memberId(memberId)
				.bookTitle(bookmarkVo.getTitle())
				.isbn(bookmarkVo.getIsbn())
				.build();
	}

}
