package com.koo.member.application.bookmark;

import com.koo.member.application.MemberService;
import com.koo.member.application.bookmark.exception.CannotFindMemberBookmarksException;
import com.koo.member.application.exception.AlreadySavedIsbn;
import com.koo.member.domain.Member;
import com.koo.member.domain.bookmark.Bookmark;
import com.koo.member.domain.bookmark.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class BookmarkService {
	@Autowired
	private BookmarkRepository bookmarkRepository;

	@Autowired
	private MemberService memberService;

	public List<String> getBookMarkList(long memberId) {
		try {
			return bookmarkRepository.findByMemberId(memberId);
		} catch (Exception e) {
			throw new CannotFindMemberBookmarksException("회원의 bookMark 기록을 찾을 수 없습니다.");
		}

	}

	@Transactional
	public void save(BookmarkVo bookmarkVo) {
		Member member = memberService.getMember(bookmarkVo.getMemberId());
		String isbn = bookmarkVo.getIsbn();

		if (member.hasBookmakrAlready(isbn)) {
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
			.isbn(bookmarkVo.getIsbn())
			.build();
	}

}
