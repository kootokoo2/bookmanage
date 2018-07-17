package com.koo.book.infra;

import com.koo.book.domain.BookRepository;
import com.koo.book.domain.BookSearchResult;
import com.koo.utils.MultiValueMapConverter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * 책 검색 api
 * ex)https://dapi.kakao.com/v2/search/book?target=title&query=미움받을 용기
 */
@Component
public class ExternalBookRestTemplate implements BookRepository {
	private static final String API_AUTH = "KakaoAK a472dce9a67a519479c177c9ec9af2c1";
	private static final String PATH = "/v2/search/book";
	final String HOST = "dapi.kakao.com";

	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public BookSearchResult searchBookInfo(SearchAppKey searchAppKey) {
		URI uri = makeUri(searchAppKey);
		return request(uri);
	}

	private URI makeUri(SearchAppKey searchAppKey) {
		return UriComponentsBuilder.newInstance()
				.scheme("https")
				.host(HOST)
				.path(PATH)
				.queryParams(MultiValueMapConverter.convert(searchAppKey))
				.build()
				.encode()
				.toUri();
	}

	private BookSearchResult request(URI uri) {
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", API_AUTH);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", header);

		ResponseEntity<BookSearchResult> result = restTemplate.exchange(uri, HttpMethod.GET, entity, BookSearchResult.class);
		return result.getBody();
	}

}
