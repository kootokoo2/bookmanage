package com.koo.book.infra;

import com.koo.book.application.SearchAppKey;
import com.koo.book.domain.BookRepository;
import com.koo.book.domain.BookSearchResult;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class ExternalBookRestTemplate implements BookRepository {
	private static final String API_KEY = "a472dce9a67a519479c177c9ec9af2c1";
	private static final String URL_PREFIX = "https://dapi.kakao.com/v2/search/book";

	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public Map<String, Object> searchBookInfo(SearchAppKey searchAppKey) {
//		URI uri = URI.create(URL_PREFIX);
//
//		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
//		String result = restTemplate.getForObject("http://example.com/hotels/{hotel}/bookings/{booking}", String.class, "42", "21");
		String result = restTemplate.getForObject("http://naver.com",String.class);

//		BookSearchResult bookSearchResult = restTemplate.getForObject(uri.toString(), BookSearchResult.class, queryParams);
//		return result;
		return null;
	}

	public String test(){
		String url = URL_PREFIX + "?target=title&query=미움받을 용기";
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization","KakaoAK a472dce9a67a519479c177c9ec9af2c1");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", header);


		ResponseEntity<BookSearchResult> result = new RestTemplate().exchange(url, HttpMethod.GET, entity, BookSearchResult.class);
		return "Test";
	}
}
