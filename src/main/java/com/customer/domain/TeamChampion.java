package com.customer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * This entity contains teams's champions. 
 *
 * @author Mahnaz
 * @Jan 31, 2020
 */

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class TeamChampion {

	@Id 
	@GeneratedValue 
	private Long id;

	@NonNull
	private String teamName;

	@NonNull
	private Integer champion;
}
