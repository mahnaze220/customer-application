package com.customer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * This entity contains teams's leagues. 
 *
 * @author Mahnaz
 * @Jan 31, 2020
 */

@Entity
public class TeamLeague {

	@Id 
	@GeneratedValue 
	private Long id;

	private String teamName;

	private Integer league;

	public TeamLeague() {
		super();
	}

	public TeamLeague(String teamName, Integer league) {
		super();
		this.teamName = teamName;
		this.league = league;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getLeague() {
		return league;
	}

	public void setLeague(Integer league) {
		this.league = league;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("TeamLeague {");
		sb.append("Team Name='").append(teamName).append('\'');
		sb.append(", League='").append(league).append('\'');
		return sb.toString();
	}
}
