package com.koo.web;

import com.koo.book.application.BookSearchService;
import com.koo.book.application.SearchAppKey;
import com.koo.book.application.SearchTarget;
import com.koo.book.domain.BookSearchResult;
import com.koo.book.domain.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

	@Autowired
	private BookSearchService bookSearchService;

	@PostMapping("/searchBook")
	public ModelAndView search(@RequestBody @Valid SearchAppKey searchAppKey, @CookieValue(value = "memberId") String memberId){
		BookSearchResult bookSearchResult = bookSearchService.searchBookInfo(searchAppKey, Long.valueOf(memberId));

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("search/searchResult");
		modelAndView.addObject("bookSearchResult", bookSearchResult);
		return modelAndView;
	}

	@GetMapping("/bookDetail/{target}/{query}")
	public ModelAndView detailSearch(@PathVariable String target, @PathVariable String query) {
		SearchAppKey searchAppKey = SearchAppKey.builder()
			.target(SearchTarget.valueOf(target))
			.query(query)
			.build();
		Document document = bookSearchService.detailSearch(searchAppKey);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("book/detail");
		modelAndView.addObject("document", document);
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
