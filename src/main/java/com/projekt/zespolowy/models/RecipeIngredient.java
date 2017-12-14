package com.projekt.zespolowy.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient {
	
	@Id
	@GeneratedValue
	private long id;
	private int amount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "recipe_id")
	private Recipe recipe;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ingredient_id")
	private Ingredient ingredient;

	public Ingredient getIngredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
