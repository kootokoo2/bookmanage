package com.koo.book.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Meta {
	private int total_count;
	private int pageable_count;
	private boolean is_end;
}
