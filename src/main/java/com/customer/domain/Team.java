package com.customer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * This entity contains teams's information. 
 *
 * @author Mahnaz
 * @Jan 31, 2020
 */

@Entity
public class Team {

	@Id 
	@GeneratedValue 
	private Long id;
	
	private String name;

	public Team() {
		super();
	}

	public Team(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Team [name=" + name + "]";
	}
}
