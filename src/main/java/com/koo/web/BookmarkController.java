package com.koo.web;

import com.koo.bookmark.application.BookmarkService;
import com.koo.bookmark.application.BookmarkVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookmarkController {

	@Autowired
	private BookmarkService bookmarkService;


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
