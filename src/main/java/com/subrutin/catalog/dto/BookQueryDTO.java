package com.subrutin.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class BookQueryDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6659767836628899525L;

	private Long id;
	
	private String bookId;
	
	private String bookTitle;
	
	private String publisherName;
	
	private String description;

}
