package com.projekt.zespolowy.models;

import java.sql.Blob;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "recipe")
public class Recipe {
	
	@Id
	@GeneratedValue
	@Column(name = "recipe_id")
	private long id;
	private String name;
	private String description;
	private String preparation;
	@Lob
	private Blob photo;
	
	@OneToMany(mappedBy = "recipe")
	private Set<RecipeIngredient> recipeIngredient;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "category_recipe",
	        joinColumns = @JoinColumn(name = "recipe_id"),
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
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPreparation() {
		return preparation;
	}
	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}
}
