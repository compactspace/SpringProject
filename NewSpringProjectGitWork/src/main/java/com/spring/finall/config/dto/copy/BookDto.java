package com.spring.finall.config.dto.copy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
	private int bookId;
	private String name;
	private int price;
	private String publisher;
}
