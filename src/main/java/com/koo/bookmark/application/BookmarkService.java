package com.koo.bookmark.application;

import com.koo.bookmark.domain.bookmark.Bookmark;
import com.koo.bookmark.domain.bookmark.BookmarkRepository;
import com.koo.member.application.MemberService;
import com.koo.member.application.exception.AlreadySavedIsbn;
import com.koo.member.domain.Member;
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

	public boolean isExistBookmark(Long memberId, String isbn) {
		Optional<Bookmark> byMemberIdAndIsbn = bookmarkRepository.findByMemberIdAndIsbn(memberId, isbn);
		return byMemberIdAndIsbn.isPresent();
	}

	@Transactional
	public void save(BookmarkVo bookmarkVo) {
		Member member = memberService.getMember(bookmarkVo.getMemberId());
		String isbn = bookmarkVo.getIsbn();

		if (member.hasBookmakrAlready(isbn)) {
			throw new AlreadySavedIsbn("이미 저장된 ISBN 입니다. isbn : " + isbn);
		} else {
			Bookmark bookmark = makeBookmark(bookmarkVo.getIsbn(), member.getId());
			member.getBookmarkList().add(bookmark);
			bookmarkRepository.save(bookmark);
		}
	}

	@Transactional
	public void delete(BookmarkVo bookmarkVo) {
		bookmarkRepository.deleteByMemberIdAndIsbn(bookmarkVo.getMemberId(), bookmarkVo.getIsbn());
	}

	private Bookmark makeBookmark(String isbn, Long memberId) {
		Bookmark bookmark = new Bookmark();
		bookmark.setMemberId(memberId);
		bookmark.setIsbn(isbn);
		return bookmark;
	}

}
