package com.koo.web;

import com.koo.member.application.bookmark.BookmarkService;
import com.koo.member.application.bookmark.BookmarkVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookmarkController {

	@Autowired
	private BookmarkService bookmarkService;

	@GetMapping("/find")
	public List<String> getBookMarkList(@CookieValue(value = "memberId") String memberId) {
		return bookmarkService.getBookMarkList(Long.valueOf(memberId));
	}

	@PostMapping("/bookmark/save")
	public String save(@RequestBody BookmarkVo bookmarkVo, @CookieValue(value = "memberId") String memberId) {
		bookmarkVo.setMemberId(Long.valueOf(memberId));
		bookmarkService.save(bookmarkVo);
		return "success";
	}

	@PostMapping("/bookmark/delete")
	public String delete(@RequestBody BookmarkVo bookmarkVo, @CookieValue(value = "memberId") String memberId) {
		bookmarkVo.setMemberId(Long.valueOf(memberId));
		bookmarkService.delete(bookmarkVo);
		return "success";
	}

}
