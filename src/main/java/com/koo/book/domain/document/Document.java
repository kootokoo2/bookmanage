package com.koo.book.domain.document;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Document {
	private List<String> authors;
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
	private List<String> translators;
}

