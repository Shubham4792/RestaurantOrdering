package edu.buffalo.cse.ood.restaurantOrdering.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

@Data
@Entity
@JsonDeserialize(as = RecipeItem.class)
public abstract class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(nullable = false, unique = true)
	private String name;
	@Column(nullable = false)
	private double price;
	private long calories;
}
