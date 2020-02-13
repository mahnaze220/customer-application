package com.customer.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * This DTO contains response data of fetched dimensions. 
 *
 * @author Mahnaz
 * @Jan 31, 2020
 */

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class CustomerDimensionResponse {

	@NonNull
	@JsonProperty("team")
	@ApiModelProperty(notes = "team")
	private List<String> data;
}
