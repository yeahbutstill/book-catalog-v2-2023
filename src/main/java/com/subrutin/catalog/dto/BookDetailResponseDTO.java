package com.subrutin.catalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class BookDetailResponseDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7889938648939242355L;

	private String bookId;
	
	private List<AuthorResponseDTO> authors;
	
	private List<CategoryListResponseDTO> categories;
	
	private PublisherResponseDTO publisher;
	
	private String bookTitle;
	
	private String bookDescription;

	
	

}
