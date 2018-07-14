package com.koo.book.domain.document;

import com.koo.book.domain.document.author.Author;
import com.koo.book.domain.document.transrator.Translator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Document {
	private List<Author> authors;
	private String barcode;
	private String category;
	private String contents;
	private Date datetime;
	private String ebook_barcode;
	private String isbn;
	private long price;
	private String publisher;
	private long sale_price;
	private String sale_yn;
	private String status;
	private String thumbnail;
	private String title;
	private String url;
	private List<Translator> translators;
}

