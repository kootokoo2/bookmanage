package com.koo.web;

import com.koo.member.application.bookmark.BookmarkService;
import com.koo.member.application.bookmark.BookmarkVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookmarkController {

	@Autowired
	private BookmarkService bookmarkService;


	@PostMapping("/bookmark/save")
	public String save(@RequestBody BookmarkVo bookmarkVo) {
		bookmarkService.save(bookmarkVo);
		return "scucess";
	}

	@PostMapping("/bookmark/delete")
	public String delete(@RequestBody BookmarkVo bookmarkVo){
		bookmarkService.delete(bookmarkVo);
		return "scucess";
	}

}
