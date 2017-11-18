package edu.buffalo.cse.ood.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Component
@Scope("prototype")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String address;
	@OneToOne
	private RestaurantOwner owner;
	@OneToMany
	private List<Deal> availableDeals = new ArrayList<Deal>();
	@OneToMany
	private List<Item> availableItems = new ArrayList<Item>();
	@ElementCollection(targetClass= Day.class)
	private List<Day> openDays = new ArrayList<Day>();
	@OneToMany
	private List<Order> allOrders = new ArrayList<Order>();
}
