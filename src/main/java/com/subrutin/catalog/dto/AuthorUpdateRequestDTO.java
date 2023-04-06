package com.subrutin.catalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class AuthorUpdateRequestDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9092436032398827798L;

	private String authorName;

	private Long birthDate;
	
	private List<AddressUpdateRequestDTO> addresses;
}
