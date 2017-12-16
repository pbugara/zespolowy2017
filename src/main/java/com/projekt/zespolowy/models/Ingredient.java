package com.projekt.zespolowy.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue
	@Column(name = "ingredient_id")
	private long id;
	private String name;
	private String description;
	private String serving;
	private double calories;
	private double fat;
	private double sugar;
	private double protein;
	private double indexg;
	private double salt;
	
	@OneToMany(mappedBy = "ingredient")
	private Set<RecipeIngredient> recipeIngredient;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "category_ingredient",
	        joinColumns = @JoinColumn(name = "ingredient_id"),
	        inverseJoinColumns = @JoinColumn(name = "category_id")
	)
	private Set<Category> category;
	
	public Set<Category> getCategory() {
		return category;
	}
	public void setCategory(Set<Category> category) {
		this.category = category;
	}
	
	public Set<RecipeIngredient> getRecipeIngredient() {
		return recipeIngredient;
	}
	public void setRecipeIngredient(Set<RecipeIngredient> recipeIngredient) {
		this.recipeIngredient = recipeIngredient;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getServing() {
		return serving;
	}
	public void setServing(String serving) {
		this.serving = serving;
	}
	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getSugar() {
		return sugar;
	}
	public void setSugar(double sugar) {
		this.sugar = sugar;
	}
	
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	public double getIndexg() {
		return indexg;
	}
	public void setIndexg(double indexg) {
		this.indexg = indexg;
	}
	public double getSalt() {
		return salt;
	}
	public void setSalt(double salt) {
		this.salt = salt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
