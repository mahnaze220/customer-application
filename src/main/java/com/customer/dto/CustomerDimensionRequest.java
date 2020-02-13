package com.customer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * This DTO contains request data for retrieving dimensions. 
 *
 * @author Mahnaz
 * @Jan 31, 2020
 */

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class CustomerDimensionRequest {

	@NonNull
	@JsonProperty("dimensionName")
	@ApiModelProperty(notes = "dimensionName")
	private String dimensionName;

}
