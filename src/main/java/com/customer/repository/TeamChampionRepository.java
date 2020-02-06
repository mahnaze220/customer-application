package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.domain.TeamChampion;

/**
 * This repository contains CRUD and search operation on TeamChampion entity.
 *
 * @author Mahnaz
 * @Jan 31, 2020
 */

public interface TeamChampionRepository extends JpaRepository<TeamChampion, Long> {

}
