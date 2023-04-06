package com.subrutin.catalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublisherResponseDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6537316926933523618L;

	private String publisherId;
	
	private String publisherName;

}
