package com.masai.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reader {
	
	private String name;
	private String author;
	private String publication;
	private String category;
	private Integer pages;
	private Integer price;

}
