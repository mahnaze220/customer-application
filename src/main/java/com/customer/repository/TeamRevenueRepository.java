package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.domain.TeamRevenue;

/**
 * This repository contains CRUD and search operation on TeamRevenue entity.
 *
 * @author Mahnaz
 * @Jan 31, 2020
 */

public interface TeamRevenueRepository extends JpaRepository<TeamRevenue, Long> {
}
