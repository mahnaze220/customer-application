package com.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.domain.Team;
import com.customer.domain.TeamChampion;
import com.customer.domain.TeamLeague;
import com.customer.domain.TeamRevenue;
import com.customer.dto.CustomerDimensionRequest;
import com.customer.dto.CustomerDimensionResponse;
import com.customer.dto.CustomerMeasureRequest;
import com.customer.dto.CustomerMeasureResponse;
import com.customer.repository.TeamChampionRepository;
import com.customer.repository.TeamLeagueRepository;
import com.customer.repository.TeamRepository;
import com.customer.repository.TeamRevenueRepository;

import io.swagger.annotations.Api;

/**
 * This service provides some services for getting data from customer data's related repositories. 
 *
 * @author Mahnaz
 * @Jan 31, 2020
 */

@Service
@Api(value = "Customer Data Service")
public class CustomerDataService {

	public static final String REVENUES = "revenues";
	public static final String LEAGUES = "leagues";
	public static final String CHAMPIONS = "champions";
	public static final String TEAMS = "team";

	@Autowired
	private TeamRevenueRepository revenueRepository;

	@Autowired
	private TeamChampionRepository championRepository;

	@Autowired
	private TeamLeagueRepository leagueRepository;

	@Autowired
	private TeamRepository teamRepository;

	/**
	 * Fetch list of measures by measure's name
	 * @param request
	 * @return CustomerMeasureResponse
	 */
	public CustomerMeasureResponse getMeasure(CustomerMeasureRequest request) {

		CustomerMeasureResponse response = new CustomerMeasureResponse();
		List<Integer> data = new ArrayList<>();

		response.setName(request.getMeasureName());
		if(REVENUES.equals(request.getMeasureName())) {
			data = findAllRevenues();
		}
		else if(CHAMPIONS.equals(request.getMeasureName())) {
			data = findAllChampions();
		}
		else if(LEAGUES.equals(request.getMeasureName())) {
			data = findAllLeagues();
		}
		response.setData(data);
		return response;
	}

	/**
	 * Fetch list of categories by dimension's name
	 * @param request
	 * @return CustomerDimensionResponse
	 */
	public CustomerDimensionResponse getCategories(CustomerDimensionRequest request) {
		if(TEAMS.equals(request.getDimensionName())) {
			CustomerDimensionResponse response = new CustomerDimensionResponse();
			response.setData(new ArrayList<String>());
			List<Team> teams = teamRepository.findAll();
			teams.stream().forEach(team -> response.getData().add(team.getName()));
			return response;
		}
		return null;
	}

	public List<Integer> findAllRevenues() {
		List<Integer> data = new ArrayList<>();
		List<TeamRevenue> revenues = revenueRepository.findAll();
		for(TeamRevenue revenue : revenues) {
			data.add(revenue.getRevenue());
		}
		return data;
	}

	public List<Integer> findAllLeagues() {
		List<Integer> data = new ArrayList<>();
		List<TeamLeague> leagues = leagueRepository.findAll();
		for(TeamLeague league : leagues) {
			data.add(league.getLeague());
		}
		return data; 
	}

	public List<Integer> findAllChampions() {
		List<Integer> data = new ArrayList<>();
		List<TeamChampion> champions = championRepository.findAll();
		for(TeamChampion champion : champions) {
			data.add(champion.getChampion());
		}
		return data;
	}
}
