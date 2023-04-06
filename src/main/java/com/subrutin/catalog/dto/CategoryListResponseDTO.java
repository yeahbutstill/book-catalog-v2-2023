package com.subrutin.catalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CategoryListResponseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9145132319388794342L;
	
	private String code;
	
	private String name;
	
	private String description;

}
