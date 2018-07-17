package com.koo.web;

import com.koo.book.application.BookSearchService;
import com.koo.book.application.SearchAppKey;
import com.koo.book.application.SearchSort;
import com.koo.book.application.SearchTarget;
import com.koo.book.domain.BookSearchResult;
import com.koo.book.domain.document.Document;
import com.koo.bookmark.application.BookmarkService;
import com.koo.web.exception.QueryEmptyException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
public class BookController {

	@Autowired
	private BookSearchService bookSearchService;

	@Autowired
	private BookmarkService bookmarkService;

	@PostMapping("/searchBook")
	public ModelAndView search(@RequestBody @Valid SearchAppKey searchAppKey,
		@CookieValue(value = "memberId") String memberId) {
		BookSearchResult bookSearchResult = bookSearchService.searchBookInfo(searchAppKey, Long.valueOf(memberId));

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("search/searchResult");
		modelAndView.addObject("bookSearchResult", bookSearchResult);
		return modelAndView;
	}

	@GetMapping("/bookDetail/{target}/{query}")
	public ModelAndView detailSearch(@PathVariable String target,
		@PathVariable String query,
		@CookieValue(value = "memberId") String memberId) {
		String validatedQuery = getValidatedQuery(query);

		SearchAppKey searchAppKey = new SearchAppKey();
		searchAppKey.setTarget(SearchTarget.valueOf(target));
		searchAppKey.setQuery(validatedQuery);

		Document document = bookSearchService.detailSearch(searchAppKey);
		boolean bookmarked = bookmarkService.isBookmarked(Long.valueOf(memberId), document.getIsbn());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("book/main");
		modelAndView.addObject("document", document);
		modelAndView.addObject("bookmarked", bookmarked);

		return modelAndView;
	}

	private String getValidatedQuery(String query) {
		String[] splitQuery = query.split(" ");
		List<String> blackFilteredQuery = Arrays.stream(splitQuery).filter(a -> Strings.isNotBlank(a)).collect(Collectors.toList());

		if(blackFilteredQuery.size() == 0 ){
			throw new QueryEmptyException("빈 query 요청 입니다");
		}

		return blackFilteredQuery.get(0);
	}

	@GetMapping("/book/main")
	public ModelAndView bookMain() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("search/main");
		modelAndView.addObject("searchTargetNames", SearchTarget.getSearchTargets());
		modelAndView.addObject("searchSorts", SearchSort.getSearchSrots());
		return modelAndView;
	}

}
