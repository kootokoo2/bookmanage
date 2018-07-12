package com.koo.book.infra;

import com.koo.book.application.SearchAppKey;
import com.koo.book.domain.BookRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@Component
public class ExternalBookRepositoryImpl implements BookRepository{
	private static final String API_KEY = "a472dce9a67a519479c177c9ec9af2c1";
	private static final String URL_PREFIX = "https://dapi.kakao.com/v2/search/book";

	@Override
	public Map<String, Object> searchBookInfo(SearchAppKey searchAppKey) {
		String url =URL_PREFIX ;

		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
		//todo param 기준 url 만들어 요청

		return null;
	}
}
