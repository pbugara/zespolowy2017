package com.projekt.zespolowy.models;

import java.sql.Blob;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "recipe")
public class Recipe {
	
	@Id
	@GeneratedValue
	@Column(name = "recipe_id")
	private long id;
	private String name;
	private String description;
	@Lob
	@Column(length=5000)
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
	
	@Transient
	private float totalCalories;
	
	@Transient
	private float totalSugar;
	
	@Transient
	private float totalProtein;
	
	@Transient
	private float totalFat;
	
	@Transient
	private float totalIndexg;
	
	
	public float getTotalCalories() {
		float totalcalories = 0;
		for(RecipeIngredient recipeIngredient: getRecipeIngredient()) {
			totalcalories += recipeIngredient.getIngredient().getCalories() * recipeIngredient.getAmount()/100;
		}
		return totalcalories;
	}
	public void setTotalCalories(float totalCalories) {
		this.totalCalories = totalCalories;
	}
		
	public float getTotalSugar() {
		float totalsugar = 0;
		for(RecipeIngredient recipeIngredient: getRecipeIngredient()) {
			totalsugar += recipeIngredient.getIngredient().getSugar() * recipeIngredient.getAmount()/100;
		}
		return totalsugar;
	}
	public void setTotalSugar(float totalSugar) {
		this.totalSugar = totalSugar;
	}
		
	public float getTotalProtein() {
		float totalprotein = 0;
		for(RecipeIngredient recipeIngredient: getRecipeIngredient()) {
			totalprotein += recipeIngredient.getIngredient().getProtein() * recipeIngredient.getAmount()/100;
		}
		return totalprotein;
	}
	public void setTotalProtein(float totalProtein) {
		this.totalProtein = totalProtein;
	}
	
	public float getTotalFat() {
		float totalfat = 0;
		for(RecipeIngredient recipeIngredient: getRecipeIngredient()) {
			totalfat += recipeIngredient.getIngredient().getFat() * recipeIngredient.getAmount()/100;
		}
		return totalfat;
	}
	public void setTotalFat(float totalFat) {
		this.totalFat = totalFat;
	}
	
	public float getTotalIndexg() {
		float totalindexg =0;
		float totalsugar = getTotalSugar();
		for(RecipeIngredient recipeIngredient: getRecipeIngredient()) {
			float ingredientSugar = (float)recipeIngredient.getIngredient().getSugar() * recipeIngredient.getAmount()/100;
			totalindexg += (ingredientSugar/totalsugar)*recipeIngredient.getIngredient().getIndexg();
		}
		return totalindexg;
	}
	
	public void setTotalIndexg(float totalIndexg) {
		this.totalIndexg = totalIndexg;
	}
	
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
