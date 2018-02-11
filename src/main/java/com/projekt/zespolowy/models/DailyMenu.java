package com.projekt.zespolowy.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class DailyMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	@ManyToOne
	private User user;
	
	@ManyToMany
	private Set<Recipe> recipes;

	@Transient
	private float totalCalories;
	
	@Transient
	private float totalSugar;
	
	@Transient
	private float totalFiber;
	
	@Transient
	private float totalProtein;
	
	@Transient
	private float totalFat;
	
	@Transient
	private float totalIG;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public float getTotalCalories() {
		float total = 0;
		for(Recipe recipe:this.getRecipes()) {
			total += recipe.getTotalCalories();
		}
		return total;
	}

	public void setTotalCalories(float totalCalories) {
		this.totalCalories = totalCalories;
	}

	public float getTotalSugar() {
		float total = 0;
		for(Recipe recipe:this.getRecipes()) {
			total += recipe.getTotalSugar();
		}
		return total;
	}

	public void setTotalSugar(float totalSugar) {
		this.totalSugar = totalSugar;
	}
	
	public float getTotalFiber() {
		float total = 0;
		for(Recipe recipe:this.getRecipes()) {
			total += recipe.getTotalFiber();
		}
		return total;
	}

	public void setTotalFiber(float totalFiber) {
		this.totalFiber = totalFiber;
	}

	public float getTotalProtein() {
		float total = 0;
		for(Recipe recipe:this.getRecipes()) {
			total += recipe.getTotalProtein();
		}
		return total;
	}

	public void setTotalProtein(float totalProtein) {
		this.totalProtein = totalProtein;
	}

	public float getTotalIG() {
		float totalindexg =0;
		float totalsugar = this.getTotalSugar();
		float totalfiber = this.getTotalFiber();
		if(totalsugar==0) return 0.0f;
		for(Recipe recipe: getRecipes()) {
			float recipeSugar = recipe.getTotalSugar();
			float recipeFiber = recipe.getTotalFiber();
			totalindexg += ((recipeSugar-recipeFiber)/(totalsugar-totalfiber))*recipe.getTotalIndexg();
		}
		return totalindexg;
	}

	public void setTotalIG(float totalIG) {
		this.totalIG = totalIG;
	}

	public float getTotalFat() {
		float total = 0;
		for(Recipe recipe:this.getRecipes()) {
			total += recipe.getTotalFat();
		}
		return total;
	}

	public void setTotalFat(float totalFat) {
		this.totalFat = totalFat;
	}
}
