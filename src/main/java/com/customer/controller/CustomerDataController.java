package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.dto.CustomerDimensionRequest;
import com.customer.dto.CustomerDimensionResponse;
import com.customer.dto.CustomerMeasureRequest;
import com.customer.dto.CustomerMeasureResponse;
import com.customer.service.CustomerDataService;

/**
 * This rest service provides some services for running queries on the customer database.
 *
 * @author Mahnaz
 * @Jan 31, 2020
 */

@RestController
public class CustomerDataController {

	@Autowired
	private CustomerDataService customerDataService;

	/**
	 * This method runs a query to retrieve list of categories based on input dimension
	 * @param dataRequest
	 * @return CustomerDataResponse
	 */
	@PostMapping("/customerData")
	public ResponseEntity<CustomerDimensionResponse> getCategories(@RequestBody CustomerDimensionRequest dataRequest) {
		CustomerDimensionResponse response = customerDataService.getCategories(dataRequest);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	/**
	 * This method runs a query to retrieve list of series based on input measure
	 * @param dataRequest
	 * @return CustomerMeasureResponse
	 */
	@PostMapping("/customerMeasureData")
	public ResponseEntity<CustomerMeasureResponse> getMeasureData(@RequestBody CustomerMeasureRequest dataRequest) {
		CustomerMeasureResponse response = customerDataService.getMeasure(dataRequest);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
