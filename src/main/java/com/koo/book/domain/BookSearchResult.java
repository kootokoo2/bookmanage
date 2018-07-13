package com.koo.book.domain;

import com.koo.book.domain.document.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookSearchResult {
	private Meta meta;
	private List<Document> documents;

}
