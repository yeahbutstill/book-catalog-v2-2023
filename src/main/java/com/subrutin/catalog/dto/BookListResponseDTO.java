package com.subrutin.catalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookListResponseDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4836684745260708430L;

	private String id;
	
	private String title;
	
	private String description;
	
	private String publisherName;
	
	private List<String> categoryCodes;
	
	private List<String> authorNames;

}
