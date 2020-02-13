package com.customer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * This entity contains teams's leagues. 
 *
 * @author Mahnaz
 * @Jan 31, 2020
 */

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class TeamLeague {

	@Id 
	@GeneratedValue 
	private Long id;

	@NonNull
	private String teamName;

	@NonNull
	private Integer league;
}
