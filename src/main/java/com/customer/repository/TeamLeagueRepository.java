package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.domain.TeamLeague;

/**
 * This repository contains CRUD and search operation on TeamLeague entity.
 *
 * @author Mahnaz
 * @Jan 31, 2020
 */

public interface TeamLeagueRepository extends JpaRepository<TeamLeague, Long> {

}
