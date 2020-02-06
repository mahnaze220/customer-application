package com.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

/**
 * This unit test contains test scenarios for CustomerDataService. 
 *
 * @author Mahnaz
 * @Jan 31, 2020
 */

@SpringBootTest
public class CustomerDataServiceUT {

	private static final String TEAMS = "team";
	private static final String REVENUES = "revenues";
	private static final String CHAMPIONS = "champions";
	private static final String LEAGUES = "leagues";

	@Autowired
	private CustomerDataService customerDataService;

	@Mock
	private TeamLeagueRepository leagueRepository;

	@Mock
	private TeamChampionRepository championRepository;

	@Mock
	private TeamRevenueRepository revenueRepository;

	@Mock
	private TeamRepository teamRepository;

	@Test
	public void getCategories_whenSetTeamDimension_returnListOfTeams() throws Exception{
		Mockito.doReturn(createAllTeams()).when(teamRepository).findAll(); 

		CustomerDimensionResponse response = customerDataService.getCategories(createDataRequest());
		Assertions.assertEquals(5, response.getData().size());
	}

	@Test
	public void getMeasure_setMeasureAsLeague_listOfLeagueMeasure() throws Exception{
		CustomerDataService customerServiceSpy = Mockito.spy(customerDataService);

		Mockito.doReturn(createAllLeagues()).when(customerServiceSpy).findAllLeagues(); 

		CustomerMeasureResponse response = customerDataService.getMeasure(createLeagueMeasureRequest());
		Assertions.assertEquals(5, response.getData().size());
	}

	@Test
	public void getMeasure_setMeasureAsChampion_listOfChampionMeasure() throws Exception{
		CustomerDataService spyTemp = Mockito.spy(customerDataService);

		Mockito.doReturn(createAllChampions()).when(spyTemp).findAllChampions(); 

		CustomerMeasureResponse response = customerDataService.getMeasure(createChampionMeasureRequest());
		Assertions.assertEquals(5, response.getData().size());
	}

	@Test
	public void getMeasure_setMeasureAsRevenue_listOfRevenueMeasure() throws Exception{
		CustomerDataService spyTemp = Mockito.spy(customerDataService);

		Mockito.doReturn(createAllRevenues()).when(spyTemp).findAllRevenues(); 

		CustomerMeasureResponse response = customerDataService.getMeasure(createRevenueMeasureRequest());
		Assertions.assertEquals(5, response.getData().size());
	}

	public CustomerDimensionRequest createDataRequest() {
		return new CustomerDimensionRequest(TEAMS);
	}

	public CustomerMeasureRequest createLeagueMeasureRequest() {
		List<String> measures = new ArrayList<>();
		return new CustomerMeasureRequest(LEAGUES, measures);
	}

	public CustomerMeasureRequest createChampionMeasureRequest() {
		List<String> measures = new ArrayList<>();
		return new CustomerMeasureRequest(CHAMPIONS, measures);
	}

	public CustomerMeasureRequest createRevenueMeasureRequest() {
		List<String> measures = new ArrayList<>();
		return new CustomerMeasureRequest(REVENUES, measures);
	}

	public List<Team> createAllTeams() {
		List<Team> teams = new ArrayList<>();
		teams.add(new Team("Real Madrid"));
		teams.add(new Team("Barcelona"));
		teams.add(new Team("Bayern Munich"));
		teams.add(new Team("Liverpool"));
		teams.add(new Team("Milan"));
		return teams;
	}

	public List<TeamRevenue> createAllRevenues() {
		List<TeamRevenue> revenues = new ArrayList<>();
		revenues.add(new TeamRevenue("Real Madrid", 625));
		revenues.add(new TeamRevenue("Barcelona", 620));
		revenues.add(new TeamRevenue("Bayern Munich", 600));
		revenues.add(new TeamRevenue("Liverpool", 400));
		revenues.add(new TeamRevenue("Milan", 250));
		return revenues;
	}

	public List<TeamLeague> createAllLeagues() {
		List<TeamLeague> leagues = new ArrayList<>();
		leagues.add(new TeamLeague("Real Madrid", 33));
		leagues.add(new TeamLeague("Barcelona", 24));
		leagues.add(new TeamLeague("Bayern Munich", 26));
		leagues.add(new TeamLeague("Liverpool", 18));
		leagues.add(new TeamLeague("Milan", 18));
		return leagues;
	}

	public List<TeamChampion> createAllChampions() {
		List<TeamChampion> champions = new ArrayList<>();
		champions.add(new TeamChampion("Real Madrid", 12));
		champions.add(new TeamChampion("Barcelona", 5));
		champions.add(new TeamChampion("Bayern Munich", 5));
		champions.add(new TeamChampion("Liverpool", 5));
		champions.add(new TeamChampion("Milan", 7));
		return champions;
	}
}
