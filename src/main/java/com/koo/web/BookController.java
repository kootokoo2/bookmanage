package com.koo.web;

import com.koo.book.application.BookSearchService;
import com.koo.book.application.SearchAppKey;
import com.koo.book.domain.BookSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class BookController {

	@Autowired
	private BookSearchService bookSearchService;

	@PostMapping("/book/search")
	public ModelAndView search(@RequestBody SearchAppKey searchAppKey) {
		BookSearchResult bookSearchResult = bookSearchService.searchBookInfo(searchAppKey, searchAppKey.getMemberId());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/search/search");
		modelAndView.addObject("bookSearchResult", bookSearchResult);
		return modelAndView;
	}

	@GetMapping("/book/main")
	public ModelAndView bookMain() {
		List<String> searchTargetNames = bookSearchService.getSearchTargetList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("search/main");
		modelAndView.addObject("searchTargetNames", searchTargetNames);
		return modelAndView;
	}

}
