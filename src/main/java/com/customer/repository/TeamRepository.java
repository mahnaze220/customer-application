package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.domain.Team;

/**
 * This repository contains CRUD and search operation on Team entity.
 *
 * @author Mahnaz
 * @Jan 31, 2020
 */

public interface TeamRepository extends JpaRepository<Team, Long> {

}
