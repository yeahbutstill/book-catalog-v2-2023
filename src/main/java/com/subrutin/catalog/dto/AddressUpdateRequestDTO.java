package com.subrutin.catalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressUpdateRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7707199363640646835L;
	
	private Long addressId;

	private String streetName;
	
	private String cityName;
	
	private String zipCode;
}
