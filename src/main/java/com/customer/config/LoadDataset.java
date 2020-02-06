package com.customer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.customer.domain.Team;
import com.customer.domain.TeamChampion;
import com.customer.domain.TeamLeague;
import com.customer.domain.TeamRevenue;
import com.customer.repository.TeamChampionRepository;
import com.customer.repository.TeamLeagueRepository;
import com.customer.repository.TeamRepository;
import com.customer.repository.TeamRevenueRepository;

/**
 * This class creates mock data for test data set.
 *
 * @author Mahnaz
 * @Jan 31, 2020
 */

@Configuration
public class LoadDataset {

	private static final Logger log = LoggerFactory.getLogger(LoadDataset.class);

	@Bean
	CommandLineRunner initDatabase(TeamRepository teamRepository, TeamRevenueRepository revenueRepository,
			TeamChampionRepository championRepository, TeamLeagueRepository leagueRepository) {
		return args -> {
			log.info("Loading mock data ");
			teamRepository.save(new Team("Real Madrid"));
			teamRepository.save(new Team("Barcelona"));
			teamRepository.save(new Team("Bayern Munich"));
			teamRepository.save(new Team("Liverpool"));
			teamRepository.save(new Team("Milan"));

			revenueRepository.save(new TeamRevenue("Real Madrid", 625));
			revenueRepository.save(new TeamRevenue("Barcelona", 620));
			revenueRepository.save(new TeamRevenue("Bayern Munich", 600));
			revenueRepository.save(new TeamRevenue("Liverpool", 400));
			revenueRepository.save(new TeamRevenue("Milan", 250));

			championRepository.save(new TeamChampion("Real Madrid", 12));
			championRepository.save(new TeamChampion("Barcelona", 5));
			championRepository.save(new TeamChampion("Bayern Munich", 5));
			championRepository.save(new TeamChampion("Liverpool", 5));
			championRepository.save(new TeamChampion("Milan", 7));

			leagueRepository.save(new TeamLeague("Real Madrid", 33));
			leagueRepository.save(new TeamLeague("Barcelona", 24));
			leagueRepository.save(new TeamLeague("Bayern Munich", 26));
			leagueRepository.save(new TeamLeague("Liverpool", 18));
			leagueRepository.save(new TeamLeague("Milan", 18));
		};
	}
}
