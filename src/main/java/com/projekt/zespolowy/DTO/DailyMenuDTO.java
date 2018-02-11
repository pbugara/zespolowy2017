package com.projekt.zespolowy.DTO;

import java.util.ArrayList;
import java.util.List;

import com.projekt.zespolowy.models.Recipe;
import com.projekt.zespolowy.models.RecipeIngredient;

public class DailyMenuDTO {
	
	private String name;
	private List<Recipe> recipeList;
	private List<StringDTO> recipeIds;
	private Long recipeIdToAdd;
	private float totalCalories;
	private float totalSugar;
	private float totalFiber;
	private float totalProtein;
	private float totalIG;
	private float totalFat;
	
	public DailyMenuDTO() {
		this.recipeList = new ArrayList<>();
		this.recipeIds = new ArrayList<>();
	}
	
	public void addRecipe(Recipe recipe){
		this.recipeList.add(recipe);
	}

	public List<Recipe> getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(List<Recipe> recipeList) {
		this.recipeList = recipeList;
	}

	public Long getRecipeIdToAdd() {
		return recipeIdToAdd;
	}

	public void setRecipeIdToAdd(Long recipeIdtoAdd) {
		this.recipeIdToAdd = recipeIdtoAdd;
	}

	public List<StringDTO> getRecipeIds() {
		return recipeIds;
	}

	public void setRecipeIds(List<StringDTO> recipeIds) {
		this.recipeIds = recipeIds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getTotalCalories() {
		float total = 0;
		for(Recipe recipe:this.getRecipeList()) {
			total += recipe.getTotalCalories();
		}
		return total;
	}

	public void setTotalCalories(float totalCalories) {
		this.totalCalories = totalCalories;
	}

	public float getTotalSugar() {
		float total = 0;
		for(Recipe recipe:this.getRecipeList()) {
			total += recipe.getTotalSugar();
		}
		return total;
	}

	public void setTotalSugar(float totalSugar) {
		this.totalSugar = totalSugar;
	}
	
	public float getTotalFiber() {
		float total = 0;
		for(Recipe recipe:this.getRecipeList()) {
			total += recipe.getTotalFiber();
		}
		return total;
	}

	public void setTotalFiber(float totalFiber) {
		this.totalFiber = totalFiber;
	}

	public float getTotalProtein() {
		float total = 0;
		for(Recipe recipe:this.getRecipeList()) {
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
		for(Recipe recipe: getRecipeList()) {
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
		for(Recipe recipe:this.getRecipeList()) {
			total += recipe.getTotalFat();
		}
		return total;
	}

	public void setTotalFat(float totalFat) {
		this.totalFat = totalFat;
	}

	
	
	
	
}
