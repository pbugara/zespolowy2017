package com.projekt.zespolowy.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private long id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "category_recipe",
	        joinColumns = @JoinColumn(name = "category_id"),
	        inverseJoinColumns = @JoinColumn(name = "recipe_id")
	)
	private Set<Recipe> recipe;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "category_ingredient",
	        joinColumns = @JoinColumn(name = "category_id"),
	        inverseJoinColumns = @JoinColumn(name = "ingredient_id")
	)
	private Set<Ingredient> ingredient;
	
	public Set<Ingredient> getIngredient() {
		return ingredient;
	}
	public void setIngredient(Set<Ingredient> ingredient) {
		this.ingredient = ingredient;
	}
	public Set<Recipe> getRecipe() {
		return recipe;
	}
	public void setRecipe(Set<Recipe> recipe) {
		this.recipe = recipe;
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
	
}
