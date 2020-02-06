package com.customer.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.customer.dto.CustomerDimensionRequest;
import com.customer.dto.CustomerDimensionResponse;
import com.customer.dto.CustomerMeasureRequest;
import com.customer.dto.CustomerMeasureResponse;
import com.customer.repository.TeamRepository;
import com.customer.service.CustomerDataService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This integration test contains test scenarios for CustomerDataController. 
 *
 * @author Mahnaz
 * @Jan 31, 2020
 */

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerDataControllerIT {

	private static final String MEASURE_SERVICE_NAME = "/customerMeasureData";
	private static final String DATA_SERVICE_NAME = "/customerData";

	private static final String TEAMS = "team";
	private static final String REVENUES = "revenues";
	private static final String CHAMPIONS = "champions";
	private static final String LEAGUES = "leagues";

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private CustomerDataService customerDataService;

	@Mock
	private TeamRepository teamRepository;

	@Test
	public void getMeasureData_whenSetRevenueMeasure_returnRevenuesList() throws Exception{

		CustomerMeasureRequest request = createRevenueMeasureRequest();
		Mockito.doReturn(createAllRevenues()).when(customerDataService).findAllRevenues();
		Mockito.when(customerDataService.getMeasure(request)).thenReturn(mockRevenueResult());

		this.mockMvc.perform(post(MEASURE_SERVICE_NAME).contentType(MediaType.APPLICATION_JSON)
				.header("accept", MediaType.APPLICATION_JSON)
				.content(convertObjectToJson(request))).andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString(REVENUES)));
	}

	@Test
	public void getMeasureData_whenSetChampionMeasure_returnChampionsList() throws Exception{

		CustomerMeasureRequest request = createChampionMeasureRequest();
		Mockito.doReturn(createAllChampions()).when(customerDataService).findAllChampions();
		Mockito.when(customerDataService.getMeasure(request)).thenReturn(mockChampionResult());

		this.mockMvc.perform(post(MEASURE_SERVICE_NAME).contentType(MediaType.APPLICATION_JSON)
				.header("accept", MediaType.APPLICATION_JSON)
				.content(convertObjectToJson(request))).andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString(CHAMPIONS)));
	}

	@Test
	public void getMeasureData_whenSetLeaguesMeasure_returnLeaguesList() throws Exception{

		CustomerMeasureRequest request = createLeagueMeasureRequest();
		Mockito.doReturn(createAllLeagues()).when(customerDataService).findAllLeagues(); 
		Mockito.when(customerDataService.getMeasure(request)).thenReturn(mockLeagueResult());

		this.mockMvc.perform(post(MEASURE_SERVICE_NAME).contentType(MediaType.APPLICATION_JSON)
				.header("accept", MediaType.APPLICATION_JSON)
				.content(convertObjectToJson(request))).andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString(LEAGUES)));
	}

	@Test
	public void getCategories_whenSetTeamDimension_returnCategories() throws Exception{

		CustomerDimensionRequest request = createDataRequest();
		Mockito.doReturn(createAllTeams()).when(teamRepository).findAll(); 
		Mockito.when(customerDataService.getCategories(request)).thenReturn(mockTeamResult());

		this.mockMvc.perform(post(DATA_SERVICE_NAME).contentType(MediaType.APPLICATION_JSON)
				.header("accept", MediaType.APPLICATION_JSON)
				.content(convertObjectToJson(request))).andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Milan")));
	}

	public CustomerMeasureResponse mockRevenueResult() {
		CustomerMeasureResponse response = new CustomerMeasureResponse();
		response.setName(REVENUES);
		response.setData(createAllRevenues());
		return response;
	}

	public CustomerMeasureResponse mockChampionResult() {
		CustomerMeasureResponse response = new CustomerMeasureResponse();
		response.setName(CHAMPIONS);
		response.setData(createAllChampions());
		return response;
	}

	public CustomerMeasureResponse mockLeagueResult() {
		CustomerMeasureResponse response = new CustomerMeasureResponse();
		response.setName(LEAGUES);
		response.setData(createAllLeagues());
		return response;
	}

	public CustomerDimensionResponse mockTeamResult() {
		CustomerDimensionResponse response = new CustomerDimensionResponse();
		response.setData(createAllTeams());
		return response;
	}

	public String convertObjectToJson(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}

	public CustomerDimensionRequest createDataRequest() {
		return new CustomerDimensionRequest(TEAMS);
	}

	public List<String> createAllTeams() {
		List<String> data = new ArrayList<>();
		data.add("Real Madrid");
		data.add("Barcelona");
		data.add("Bayern Munich");
		data.add("Liverpool");
		data.add("Milan");
		return data;
	}

	public CustomerMeasureRequest createRevenueMeasureRequest() {
		return new CustomerMeasureRequest(REVENUES, null);
	}

	public CustomerMeasureRequest createLeagueMeasureRequest() {
		return new CustomerMeasureRequest(LEAGUES, null);
	}

	public CustomerMeasureRequest createChampionMeasureRequest() {
		return new CustomerMeasureRequest(CHAMPIONS, null);
	}

	public List<Integer> createAllRevenues() {
		List<Integer> revenues = new ArrayList<>();
		revenues.add(625);
		revenues.add(620);
		revenues.add(600);
		revenues.add(400);
		revenues.add(250);
		return revenues;
	}

	public List<Integer> createAllLeagues() {
		List<Integer> leagues = new ArrayList<>();
		leagues.add(33);
		leagues.add(24);
		leagues.add(26);
		leagues.add(18);
		leagues.add(18);
		return leagues;
	}

	public List<Integer> createAllChampions() {
		List<Integer> champions = new ArrayList<>();
		champions.add(12);
		champions.add(5);
		champions.add(5);
		champions.add(5);
		champions.add(7);
		return champions;
	}
}
