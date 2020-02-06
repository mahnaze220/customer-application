package com.customer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * This entity contains teams's revenues. 
 *
 * @author Mahnaz
 * @Jan 31, 2020
 */

@Entity
public class TeamRevenue {

	@Id 
	@GeneratedValue 
	private Long id;

	private String teamName;

	private Integer revenue;

	public TeamRevenue() {
		super();
	}

	public TeamRevenue(String teamName, Integer revenue) {
		super();
		this.teamName = teamName;
		this.revenue = revenue;
	}


	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getRevenue() {
		return revenue;
	}

	public void setRevenue(Integer revenue) {
		this.revenue = revenue;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("TeamRevenue {");
		sb.append("Team Name='").append(teamName).append('\'');
		sb.append(", Revenue='").append(revenue).append('\'');
		return sb.toString();
	}
}
