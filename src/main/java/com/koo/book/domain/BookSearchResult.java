package com.koo.book.domain;

import com.koo.book.domain.document.Document;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookSearchResult {
	private Meta meta;
	private List<Document> documents;

}
