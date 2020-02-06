package com.customer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * This entity contains teams's champions. 
 *
 * @author Mahnaz
 * @Jan 31, 2020
 */

@Entity
public class TeamChampion {

	@Id 
	@GeneratedValue 
	private Long id;

	private String teamName;

	private Integer champion;

	public TeamChampion() {
		super();
	}

	public TeamChampion(String teamName, Integer champion) {
		super();
		this.teamName = teamName;
		this.champion = champion;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getChampion() {
		return champion;
	}

	public void setChampion(Integer champion) {
		this.champion = champion;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("TeamChampion {");
		sb.append("Team Name='").append(teamName).append('\'');
		sb.append(", Champion='").append(champion).append('\'');
		return sb.toString();
	}
}
