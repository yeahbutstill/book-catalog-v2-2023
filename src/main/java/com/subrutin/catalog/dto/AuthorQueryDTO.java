package com.subrutin.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AuthorQueryDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2470908329098194720L;

	private Long bookId;
	
	private String authorName;

}
